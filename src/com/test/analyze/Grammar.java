package com.test.analyze;

import java.util.*;

/**
 * Author:   lxs
 * Date:     2022/5/19 19:03
 * Description:
 */
public class Grammar {

    // 开始符号
    private final Symbol start;

    // 终结符集合
    private final Set<Symbol> vtSet;

    // 非终结符集合
    private final Set<Symbol> vnSet;

    /**
     * 这里为什么用 map 类型？
     * S -> aA | bB
     * A -> aaaa
     * A -> abab | ε
     * B -> bbb
     * B -> bababa
     * B -> ε
     * 所以对于同一个左部 Symbol (A) 其实是有多个产生式的，就是产生式租
     * 使用 LinkedHashMap ，因为产生式是要有记录顺序的
     */
    private final LinkedHashMap<Symbol, List<Production>> productionsMap;

    /**
     * 该文法所有非终结符对应的串首终结符集
     */
    private Map<Symbol, FirstSet> firstSetMap;

    /**
     * 该文法对应的 Follow 集
     */
    private Map<Symbol, FollowSet> followSetMap;

    private Grammar(Symbol start, LinkedHashMap<Symbol, List<Production>> productionsMap) {
        this.start = start;
        this.productionsMap = productionsMap;
        this.vnSet = productionsMap.keySet();
        this.vtSet = new HashSet<>();
        productionsMap.values().forEach(productionList -> productionList.forEach(production ->
                production.getRight().forEach(symbol -> {
                    if (symbol.isTerminator()) this.vtSet.add(symbol);
                })));
    }

    public static Grammar create(Symbol start, Production... productions) {
        if (productions.length == 0) {
            throw new RuntimeException("不能没有产生式");
        }
        List<Production> productionList = new ArrayList<>();
        for (Production production : productions) {
            productionList.add(production);
        }
        return create(start, productionList);
    }

    public static Grammar create(Symbol start, List<Production> productions) {
        if (productions == null || productions.isEmpty()) {
            throw new RuntimeException("不能没有产生式");
        }

        if (!start.equals(productions.get(0).getLeft())) {
            throw new RuntimeException("第一个产生式的左部[" + productions.get(0).getLeft()
                    + "] 与开始符号[" + start + "]不相同");
        }

        LinkedHashMap<Symbol, List<Production>> productionsMap = new LinkedHashMap<>();
        for (Production production : productions) {
            Symbol left = production.getLeft();
            List<Production> leftProductions = productionsMap.get(left);
            if (leftProductions == null) {
                leftProductions = new ArrayList<>();
                productionsMap.put(left, leftProductions);
            }
            leftProductions.add(production);
        }

        return new Grammar(start, productionsMap);
    }

    public static Grammar create(Symbol start, LinkedHashMap<Symbol, List<Production>> productionsMap) {
        if (productionsMap == null || productionsMap.isEmpty()) {
            throw new RuntimeException("不能没有产生式");
        }
        return new Grammar(start, productionsMap);
    }

    public Symbol getStart() {
        return start;
    }

    // 不要修改 productions 这个集合的值
    public LinkedHashMap<Symbol, List<Production>> getProductionsMap() {
        return productionsMap;
    }

    /**
     * 获取所有非终结符对应的串首终结符集
     *
     * @return
     */
    public Map<Symbol, FirstSet> getFirstSetMap() {
        // 如果有值直接返回，只求值一次
        if (firstSetMap != null) {
            return firstSetMap;
        }
        firstSetMap = new HashMap<>();
        // 遍历文法中所有非终结符，求解对应的串首终结符集
        productionsMap.keySet().forEach(key -> getOrCreateFirstSetByKey(key));
        return firstSetMap;
    }

    /**
     * 通过递归的方式，来求非终结符的串首终结符集
     *
     * @param key
     * @return
     */
    private FirstSet getOrCreateFirstSetByKey(Symbol key) {
        // 说明之前已经求过了，直接返回
        if (firstSetMap.containsKey(key)) {
            return firstSetMap.get(key);
        }
        /**
         * 右部包含 key 非终结符的产生式列表。例如 A -> aAb
         * 因为产生式右部包含key，那么就不能递归调用 getOrCreateFirstSetByKey(key) 方法，这样会形成死循环。
         * 先计算不包含 `A` 的其他产生式，得到一个 firstSet,然后再求包含`A` containsKeyProductionList
         *
         */
        List<Production> containsKeyProductionList = new ArrayList<>();
        // 该符号key 对应的串首终结符集
        FirstSet firstSet = new FirstSet(key);
        for (Production production : productionsMap.get(key)) {
            // 该产生式是空串ε
            if (production.isEpsilon()) {
                firstSet.setHasEpsilon(true);
            } else {
                List<Symbol> rightSymbols = production.getRight();
                /**
                 * 如果这个产生式右部包含这个非终结符 key，那么需要特殊处理，
                 * 加入到containsKeyProductionList中。
                 */
                if (rightSymbols.contains(key)) {
                    containsKeyProductionList.add(production);
                    continue;
                }
                Iterator<Symbol> rightIterator = rightSymbols.iterator();
                /**
                 * isAllHasEpsilon 变量表示这个产生式都是非终结符，且这些非终结符的 First集都包含空串ε
                 * 那么此 First(key) 也应该包含空串ε
                 * 这里 isAllHasEpsilon 初始值是 true，因为 production.getRight() 不可能是空集合
                 */
                boolean isAllHasEpsilon = true;
                while (rightIterator.hasNext()) {
                    Symbol currentSymbol = rightIterator.next();
                    // 如果是终结符，那么就不用继续遍历，直接将这个 currentSymbol 添加到 firstSet 中
                    if (currentSymbol.isTerminator()) {
                        firstSet.addToSet(currentSymbol);
                        isAllHasEpsilon = false;
                        // 跳出当前 while，不用再遍历这个产生式后面的字符了
                        break;
                    }
                    /**
                     * 如果是非终结符，递归调用 getOrCreateFirstSetByKey 获取这个非终结符对应的串首终结符集。
                     * 但是不允许有间接左递归，即 A -> B; B -> Aa
                     * 这样会出现死循环，就无法求解了。
                     */
                    FirstSet currentFirstSet = getOrCreateFirstSetByKey(currentSymbol);
                    firstSet.addAllToSet(currentFirstSet.getSet());
                    /**
                     * 如果当然 currentSymbol 对应的FirstSet (currentFirstSet) 包含空串，那么就需要考察下一个字符
                     * 例如 对于 S -> ABC 产生式, currentSymbol = A 且对应currentFirstSet包含空串，那么就需要将 B 的First集加入其中
                     * 如果当前字符 currentSymbol 的串首终结符集不包含空串，那么就不用再遍历这个产生式后面的字符了。
                     */
                    if (!currentFirstSet.isHasEpsilon()) {
                        isAllHasEpsilon = false;
                        break;
                    }
                }

                if (isAllHasEpsilon) {
                    firstSet.setHasEpsilon(true);
                }
            }
        }
        /**
         * 为什么分为两次遍历，因为 First(key) 是否包括空串ε，是由不包含key的其他产生式决定的。
         * 所以在遍历包含 key 的产生式的时候，就可以通过 First(key)是否包含空串ε，
         * 来决定是否添加产生式中 key 后面的字符
         */
        for (Production containsKeyProduction : containsKeyProductionList) {
            Iterator<Symbol> rightIterator = containsKeyProduction.getRight().iterator();
            while (rightIterator.hasNext()) {
                Symbol currentSymbol = rightIterator.next();
                // 如果是终结符，那么就不用继续遍历，直接将这个 currentSymbol 添加到 firstSet 中
                if (currentSymbol.isTerminator()) {
                    firstSet.addToSet(currentSymbol);
                    break;
                }
                if (currentSymbol.equals(key)) {
                    // 如果不包含空串ε，就直接跳出循环，不用遍历产生式下一个字符了
                    if (!firstSet.isHasEpsilon()) {
                        break;
                    }
                } else {
                    FirstSet currentFirstSet = getOrCreateFirstSetByKey(currentSymbol);
                    firstSet.addAllToSet(currentFirstSet.getSet());
                    if (!currentFirstSet.isHasEpsilon()) {
                        break;
                    }
                }
            }

        }
        firstSetMap.put(key, firstSet);
        return firstSet;
    }

    /**
     * 获取文法符号串对应的串首终结符集
     * 要传递所有非终结符对应的串首终结符集 firstSetMap
     *
     * @param keySymbols
     * @return
     */
    public FirstsSet getFirstsSetByKeys(List<Symbol> keySymbols) {
        // 保证初始过 firstSetMap
        Map<Symbol, FirstSet> firstSetMap = getFirstSetMap();
        // 文法符号串的串首终结符集
        FirstsSet firstsSet = new FirstsSet(keySymbols);
        Iterator<Symbol> rightIterator = keySymbols.iterator();
        /**
         * isAllHasEpsilon 变量表示这个产生式都是非终结符，且这些非终结符的 First集都包含空串ε
         * 那么此 First(key) 也应该包含空串ε
         * 这里 isAllHasEpsilon 初始值是 true，因为 keySymbols 不可能是空集合
         */
        boolean isAllHasEpsilon = true;
        while (rightIterator.hasNext()) {
            Symbol currentSymbol = rightIterator.next();
            // 如果是终结符，那么就不用继续遍历，直接将这个 currentSymbol 添加到 firstSet 中
            if (currentSymbol.isTerminator()) {
                firstsSet.addToSet(currentSymbol);
                isAllHasEpsilon = false;
                break;
            }
            // 如果是非终结符，那么需要判断
            FirstSet currentFirstSet = firstSetMap.get(currentSymbol);
            firstsSet.addAllToSet(currentFirstSet.getSet());
            /**
             * 如果当然 currentSymbol 对应的FirstSet (currentFirstSet) 包含空串，那么就需要考察下一个字符
             * 例如 对于 S -> ABC 产生式, currentSymbol = A 且对应currentFirstSet包含空串，那么就需要将 B 的First集加入其中
             */
            if (!currentFirstSet.isHasEpsilon()) {
                isAllHasEpsilon = false;
                break;
            }
        }

        if (isAllHasEpsilon) {
            firstsSet.setHasEpsilon(true);
        }

        return firstsSet;
    }


    /**
     * 取所有非终结符对应的后继符号集
     *
     * @return
     */
    public Map<Symbol, FollowSet> getFollowSetMap() {
        if (followSetMap != null) {
            return followSetMap;
        }
        getFirstSetMap();
        followSetMap = new HashMap<>();
        // 遍历文法中所有非终结符，求解对应的后继符号集
        productionsMap.keySet().forEach(key -> getOrCreateFollowSetByKey(key));
        return followSetMap;
    }

    /**
     * 通过递归的方式，来求非终结符的后继符号集
     *
     * @param key
     * @return
     */
    private FollowSet getOrCreateFollowSetByKey(Symbol key) {
        // 说明之前已经求过了，直接返回
        if (followSetMap.containsKey(key)) {
            return followSetMap.get(key);
        }
        // 该符号key 对应的后继符号集
        FollowSet followSet = new FollowSet(key);
        // 如果是文法开始符号， 要将语法终结符号放入它的 Follow 集中
        if (start.equals(key)) {
            followSet.addToSet(Symbol.END);
        }

        for (Map.Entry<Symbol, List<Production>> entry : productionsMap.entrySet()) {
            for (Production production : entry.getValue()) {
                /**
                 * 如果此产生式是空串，产生式右部不会包含字符key，遍历下一个产生式
                 * 空串是加入 First 集中,间接对 Follow集产生影响
                 */
                if (production.isEpsilon()) {
                    continue;
                }

                List<Symbol> rightSymbols = production.getRight();
                /**
                 * 判断我们要得到Follow集的 非终结符 key 在不在当前这个产生式中。
                 * 因为要得到非终结符 key 的Follow集，就要看这个产生式中此非终结符 key 后面字符的情况
                 */
                int pos = rightSymbols.indexOf(key);
                // pos == -1， 说明没有找到，那么就从下一个产生式Production寻找
                if (pos == -1) {
                    continue;
                }
                /**
                 * 如果pos == rightSymbols.size() - 1，
                 * 说明非终结符 key就是当前产生式最后一个字符，
                 * 那么就需要将该产生式左部的Follow集加入到此key 的Follow集中。
                 * 即 A -> aB, 因为B 是产生式最后一个非终结符，那么就要将 Follow(A) 加入到 Follow(B) 中
                 */
                if (pos == rightSymbols.size() - 1) {
                    // A -> aA 这种情况下，不需要做其他操作
                    if (key.equals(production.getLeft())) {
                        System.out.println("key:" + key + "   production.getLeft():" + production.getLeft());
                    } else {
                        // 将产生式左部的后继符号集添加到当前符号 key 的后继符号集中
                        // 对于 S -> aA, 要将 Follow(S) 添加到 Follow(A) 中
                        followSet.addAllToSet(getOrCreateFollowSetByKey(production.getLeft()).getSet());
                    }
                    continue;
                }

                // 当前符号 key 之后的文法符合串
                List<Symbol> remainSymbols = rightSymbols.subList(pos + 1, rightSymbols.size());
                // 获取文法符合串对应的串首终结符集
                FirstsSet firstsSet = GrammarUtils.getFirstsSetByKeys(remainSymbols, firstSetMap);
                followSet.addAllToSet(firstsSet.getSet());
                if (firstsSet.isHasEpsilon()) {
                    if (key.equals(production.getLeft())) {
                        System.out.println("key:" + key + "   production.getLeft():" + production.getLeft());
                    } else {
                        // 将产生式左部的后继符号集添加到当前符号 key 的后继符号集中
                        followSet.addAllToSet(getOrCreateFollowSetByKey(production.getLeft()).getSet());
                    }
                }
            }
        }

        followSetMap.put(key, followSet);
        return followSet;
    }


    public Set<Symbol> getVtSet() {
        return vtSet;
    }

    public Set<Symbol> getVnSet() {
        return vnSet;
    }

    private Set<Symbol> allSet;

    public Set<Symbol> getAllSet() {
        if (allSet == null) {
            allSet = new HashSet<>();
            allSet.addAll(vnSet);
            allSet.addAll(vtSet);
        }
        return allSet;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("开始符号:");
        sb.append(start);
        sb.append("\r\n");
        sb.append("产生式:\r\n");
        for (Map.Entry<Symbol, List<Production>> entry : productionsMap.entrySet()) {
            sb.append("\t\t\t\t");
            sb.append(entry.getKey());
            sb.append("->");
            for (Production production : entry.getValue()) {
                if (production.isEpsilon()) {
                    sb.append('ε');
                } else {
                    production.getRight().forEach(symbol -> sb.append(symbol.getLabel()));
                }
                sb.append("|");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\r\n");
        }
        return sb.toString();
    }
}
