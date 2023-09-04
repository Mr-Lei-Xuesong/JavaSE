package com.test.analyze;

import java.util.*;

/**
 * Author:   lxs
 * Date:     2022/5/19 19:09
 * Description:
 */
public class GrammarUtils {

    /**
     * 消除左递归
     */
    public static Grammar eliminateLeftRecursion(Grammar grammar) {
        // 先消除间接左递归
        Grammar newGrammar = eliminateIndirectLeftRecursion(grammar);
        // 再消除直接左递归
        newGrammar = eliminateDeepLeftRecursion(newGrammar);
        return newGrammar;
    }

    /**
     * 消除间接左递归
     * 如同 S -> Aa|b   A -> Ac|Sd
     * 会产生  S ==> Aa ==> Sda
     * 消除间接左递归变成
     * S -> Aa|b
     * A -> Ac|Aad|bd
     */
    public static Grammar eliminateIndirectLeftRecursion(Grammar grammar) {
        // 记录之前遍历的 产生式
        LinkedHashMap<Symbol, List<Production>> preProductionsMap = new LinkedHashMap<>();
        for (Map.Entry<Symbol, List<Production>> entry : grammar.getProductionsMap().entrySet()) {

            List<Production> entryProductions = new ArrayList<>();
            for (Production production : entry.getValue()) {
                // 得到产生式右部第一个字符，例如 A -> Sd 其中 S 就是第一个字符
                Symbol symbol = production.getRightFirst();
                // 这个产生式右部第一个字符之前出现过，例如 S -> Aa A -> Sd ，这个 S 就在之前出现过，
                // 那么就产生了间接左递归，那么就需要做转换了。就使用 S 的产生式组，替换它在A的中产生式。
                // symbol = null 没有关系，因为我们不会将 null 存入 preProductionsMap 集合中
                if (preProductionsMap.containsKey(symbol)) {
                    // 将 symbol 添加到 leftEliminateSet 集合中，表示它是间接左递归
                    List<Production> eliminateList = preProductionsMap.get(symbol);
                    for (Production eliminateProduction : eliminateList) {
                        // 例如 S -> Aa|b   A -> Ac|Sd,
                        // 这里 eliminateList 就是 [Aa, b], 要用它替换产生式[Sd]，变成 [Aad, bd]
                        entryProductions.add(Production.create(production.getLeft(),
                                production.replaceRightFirst(eliminateProduction)));
                    }
                } else {
                    // 不是间接左递归，那么就直接添加
                    entryProductions.add(production);
                }
            }
            preProductionsMap.put(entry.getKey(), entryProductions);
        }
        return Grammar.create(grammar.getStart(), preProductionsMap);
    }

    /**
     * 消除直接左递归
     * 就是将这种格式  P -> Pa|Pb|Pc|Pd|e|f|g|h
     * 转成:
     * P -> eP'|fP'|gP'|hP'
     * p'-> aP'|bP'|cP'|dP'|ε
     */
    public static Grammar eliminateDeepLeftRecursion(Grammar grammar) {
        List<Production> productions = new ArrayList<>();
        for (Map.Entry<Symbol, List<Production>> entry : grammar.getProductionsMap().entrySet()) {
            // 不包含直接左递归的 产生式集合
            List<Production> noLeftEliminateProductions = new ArrayList<>();
            // 包含直接左递归的 产生式集合; 即 A -> Aa 这种形式
            List<Production> leftEliminateProductions = new ArrayList<>();
            for (Production production : entry.getValue()) {
                if (production.isLeftEliminate()) {
                    leftEliminateProductions.add(production);
                } else {
                    noLeftEliminateProductions.add(production);
                }
            }

            // 表示这个 entry.getKey() 对应的产生式组 List<Production> 没有直接左递归产生式
            if (leftEliminateProductions.isEmpty()) {
                // 不用做任何修改，直接将 noLeftEliminateProductions 添加到 productions
                productions.addAll(noLeftEliminateProductions);
            } else {
                // 需要进行转换了, 即 A 变成 A'
                Symbol newKey = Alphabet.addSymbol(entry.getKey().getLabel() + "'", false);
                // 将原来的 P -> e|f|g|h
                // 变成    P -> eP'|fP'|gP'|hP'
                for (Production production : noLeftEliminateProductions) {
                    // 创建新的产生式右部  e 变成 eP' 或者  f 变成 fP'
                    List<Symbol> newRight = production.addSymbolToRight(newKey);
                    // 这个产生式的 left 还是 原来的
                    productions.add(Production.create(entry.getKey(), newRight));
                }

                // 将原来的 P -> Pa|Pb|Pc|Pd
                // 变成    P -> aP'|bP'|cP'|dP'|ε
                for (Production production : leftEliminateProductions) {
                    // 创建新的产生式右部  Pa 变成 aP' 或者  Pd 变成 dP'
                    List<Symbol> newRight = production.addSymbolToRightAndRemoveFirst(newKey);
                    // 这个产生式的左部，就必须是新的 key 了
                    productions.add(Production.create(newKey, newRight));
                }

                // 最后对这个新左部，必须添加 空产生式
                productions.add(Production.createEmpty(newKey));
            }
        }
        return Grammar.create(grammar.getStart(), productions);
    }

    /**
     * 提取左公因子
     *
     * @param grammar
     * @return
     */
    public static Grammar extractLeftCommonFactor(Grammar grammar) {

        for (Map.Entry<Symbol, List<Production>> entry : grammar.getProductionsMap().entrySet()) {
            TrieNode root = TrieNode.createRoot(entry.getKey());
            for (Production production : entry.getValue()) {
                root.addProductionToTree(production);
            }
            List<Production> newSymbolProductionList = new ArrayList<>();
            Production newProduction = root.extractLeftCommonFactor(newSymbolProductionList);
            System.out.println(newSymbolProductionList);
            System.out.println(newProduction);
        }

        return null;
    }


    /**
     * 求这个文法所有产生式对应的可选集List<SelectSet>
     *
     * @param grammar
     * @return
     */
    public static List<SelectSet> getAllSelectSetByGrammar(Grammar grammar) {
        // 可选集列表
        List<SelectSet> selectSetList = new ArrayList<>();

        // 当前文法的所有非终结符的后继符号集
        Map<Symbol, FollowSet> followSetMap = grammar.getFollowSetMap();
        for (Map.Entry<Symbol, List<Production>> entry : grammar.getProductionsMap().entrySet()) {
            // 遍历文法中的每个产生式
            for (Production production : entry.getValue()) {
                // 如果产生式是空产生式 A -> ε，那么 FOLLOW(A) 就是这个产生式的可选集
                if (production.isEpsilon()) {
                    FollowSet followSet = followSetMap.get(production.getLeft());
                    selectSetList.add(new SelectSet(production, followSet.getSet()));
                } else {
                    List<Symbol> rightSymbols = production.getRight();
                    // 产生式右部首字符是终结符，那么这个产生式可选集就是这个终结符
                    if (rightSymbols.get(0).isTerminator()) {
                        Set<Symbol> set = new HashSet<>();
                        set.add(rightSymbols.get(0));
                        selectSetList.add(new SelectSet(production, set));
                    } else {
                        //
                        Set<Symbol> set = new HashSet<>();
                        FirstsSet firstsSet = getFirstsSetByKeys(rightSymbols, grammar.getFirstSetMap());
                        set.addAll(firstsSet.getSet());
                        // 产生式右部的文法符号串能推导出空串ε，那么还要将产生式左部的FOLLOW集添加到这个产生式的可选集中
                        if (firstsSet.isHasEpsilon()) {
                            FollowSet followSet = followSetMap.get(production.getLeft());
                            set.addAll(followSet.getSet());
                        }
                        selectSetList.add(new SelectSet(production, set));
                    }

                }
            }
        }

        return selectSetList;
    }

    /**
     * 将可选集转换成预测分析表
     *
     * @param selectSetList
     * @return
     */
    public static Map<Symbol, Map<Symbol, Production>> listToSelectTable(List<SelectSet> selectSetList) {
        /**
         * 使用Map<Symbol, Map<Symbol, Production>> 表示一个二维表结构
         * 每一行都是一个非终结符，表中的每一列都是一个终结符，值就是产生式
         */
        Map<Symbol, Map<Symbol, Production>> table = new HashMap<>();
        for (SelectSet selectSet : selectSetList) {
            Production production = selectSet.getProduction();
            /**
             * 分析表中每一行都是非终结符，也是产生式的左部
             */
            Map<Symbol, Production> map = table.get(production.getLeft());
            if (map == null) {
                map = new HashMap<>();
                table.put(production.getLeft(), map);
            }
            /**
             * 说明当前这个产生式 production， 是非终结符 production.getLeft()， 遇到产生式的可选集字符就能选择。
             */
            for (Symbol symbol : selectSet.getSet()) {
                map.put(symbol, production);
            }
        }

        return table;
    }

    /**
     * 获取文法符号串对应的串首终结符集
     * 要传递所有非终结符对应的串首终结符集 firstSetMap
     *
     * @param keySymbols
     * @param firstSetMap
     * @return
     */
    public static FirstsSet getFirstsSetByKeys(List<Symbol> keySymbols, Map<Symbol, FirstSet> firstSetMap) {
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


    public static List<Production> match(Symbol start, Map<Symbol, Map<Symbol, Production>> table, List<Symbol> matchSymbols) {
        Stack<Symbol> stack = new Stack<>();
        stack.push(start);
        int pos = 0;
        List<Production> productions = new ArrayList<>();
        while (!stack.isEmpty()) {
            // 获取当前栈顶字符
            Symbol currentSymbol = stack.pop();
            // 获取待匹配输入字符串当前位置 pos 对应的待匹配字符
            Symbol matchSymbol = matchSymbols.get(pos);
            // 如果匹配成功说明，就让pos自增，匹配下一个字符
            if (currentSymbol.equals(matchSymbol)) {
                pos++;
            } else if (currentSymbol.isTerminator()) {
                // 当前符号 currentSymbol 是终结符，还不能匹配成功，那么说明语法匹配错误
                throw new RuntimeException("当前符号:" + currentSymbol + "  待匹配符号:" + matchSymbol);
            } else {
                Map<Symbol, Production> map = table.get(currentSymbol);
                if (map == null) {
                    throw new RuntimeException("当前符号:" + currentSymbol + " 对应的分析表");
                }
                Production production = map.get(matchSymbol);
                if (production == null) {
                    throw new RuntimeException("当前符号:" + currentSymbol + " 对应的分析表");
                }
                // 匹配成功的产生式
                productions.add(production);
                // 将产生式倒序存入栈中
                List<Symbol> right = production.getRight();
                for (int index = right.size() - 1; index >= 0; index--) {
                    stack.push(right.get(index));
                }
            }
        }

        return productions;
    }
}
