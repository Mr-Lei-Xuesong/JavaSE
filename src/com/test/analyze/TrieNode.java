package com.test.analyze;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:   lxs
 * Date:     2022/5/19 19:09
 * Description:
 */
public class TrieNode {

    /**
     * 表示这棵树属于那一个非终结符
     * 这棵树中每一个节点这个字段是一样的，也与productions中产生式左部相同。
     */
    private final Symbol productionKey;

    /**
     * 当前树节点对应的符号
     */
    private final Symbol symbol;

    /**
     * 表示当前树节点到根节点符号的集合
     * 例如 产生式是 S -> abcAB
     * 当前节点是 c ，那么这个 prefixSymbols 就是 [a, b, c]
     */
    private List<Symbol> prefixSymbols;
    /**
     * 当前树节点的子节点
     */
    private List<TrieNode> childList = new ArrayList<>();
    /**
     * 当前树节点包含的所有产生式，因为产生式对应一个路径，所以也就是当前树节点下面有几条路径。
     */
    private List<Production> productions = new ArrayList<>();

    private TrieNode(Symbol productionKey, Symbol symbol, List<Symbol> prefixSymbols) {
        this.productionKey = productionKey;
        this.symbol = symbol;
        this.prefixSymbols = prefixSymbols;
    }

    public static TrieNode createRoot(Symbol productionKey) {
        /**
         * 树根不包含具体字符, 前缀字符列表也是空
         */
        return new TrieNode(productionKey, null, new ArrayList<>(0));
    }

    /**
     * 向树中添加一个产生式
     *
     * @param production
     */
    public void addProductionToTree(Production production) {
        TrieNode parentNode = this;
        parentNode.productions.add(production);
        for (Symbol symbol : production.getRight()) {
            TrieNode symbolNode = null;
            for (TrieNode childNode : parentNode.childList) {
                if (childNode.symbol.equals(symbol)) {
                    symbolNode = childNode;
                    break;
                }
            }
            if (symbolNode == null) {
                List<Symbol> prefixSymbols = new ArrayList<>(parentNode.prefixSymbols);
                prefixSymbols.add(symbol);
                symbolNode = new TrieNode(productionKey, symbol, prefixSymbols);
                parentNode.childList.add(symbolNode);
            }
            symbolNode.productions.add(production);
            parentNode = symbolNode;
        }
    }

    private static int newSymbolCount = 0;

    private static Symbol newSymbol(Symbol currentProductionLeft) {
        newSymbolCount++;
        StringBuilder sb = new StringBuilder(currentProductionLeft.getLabel());
        for (int index = 0; index < newSymbolCount; index++) {
            sb.append("'");
        }
        return Alphabet.addSymbol(sb.toString(), false);
    }


    /**
     * 通过递归的方式，获取提取左公因子后的产生式列表，包括新字符对应的产生式列表
     * 返回的 Production 表示处理过的路径对应产生式，即合并了多条子路径后的产生式
     * 因为我们使用递归的方式，所以用 newProductionList 来存储产生的新的字符串
     *
     * @param newProductionList
     * @return
     */
    public Production extractLeftCommonFactor(List<Production> newProductionList) {
        /**
         * 如果 productions.size() == 1，表示从当前树节点往下的路径只有一个，没有分叉，
         * 那么它下面就不会有公共前缀的产生式，不用再向下递归了。
         */
        if (productions.size() == 1) {
            // 直接返回列表中唯一的产生式，也不需要对产生式做处理
            return productions.get(0);
        }
        /**
         * 表示当前树节点下面已经做过处理的产生式列表。
         * 因为如果当前树节点下面子路径有公共前缀，那么有公共前缀的多个产生式要合并成一个产生式返回才行。
         */
        List<Production> childHandledProductions = new ArrayList<>();
        for (TrieNode child : childList) {
            // 返回做过处理的子产生式
            Production handledProduction = child.extractLeftCommonFactor(newProductionList);
            childHandledProductions.add(handledProduction);
        }
        /**
         * 当 symbol == null, 表示是树的根节点。
         * 根节点的分叉路径不用做处理。
         */
        if (symbol == null) {
            newProductionList.addAll(childHandledProductions);
            return null;
        }
        /**
         * 处理过的产生式路径只有一条，那么也是直接返回它
         */
        if (childHandledProductions.size() == 1) {
            return childHandledProductions.get(0);
        }


        /**
         * 需要合并路径，生成新的字符，例如 S' S'' S'''
         * 将新的字符指向分叉路径
         */
        Symbol newSymbol = newSymbol(productionKey);

        /**
         * 整个计算规则就是:
         * S -> aaaC | aaaD
         * 先生成新的字符S' (newSymbol)，
         * 将 S' -> C | D
         * 最后再生成合并后的产生式 S -> aaaS' 返回。
         *
         */
        for (Production production : childHandledProductions) {
            List<Symbol> newSymbolSymbolList = new ArrayList<>();
            // 当前节点之后的字符，
            for (int index = prefixSymbols.size(); index < production.getRight().size(); index++) {
                newSymbolSymbolList.add(production.getRight().get(index));
            }
            // 生成新字符对应的产生式
            Production newSymbolProduction = Production.create(newSymbol, newSymbolSymbolList);
            newProductionList.add(newSymbolProduction);
        }


        /**
         * 生成合并后的产生式
         */
        List<Symbol> newSymbolList = new ArrayList<>(prefixSymbols);
        newSymbolList.add(newSymbol);
        Production newProduction = Production.create(productionKey, newSymbolList);
        return newProduction;
    }


    /**
     * 通过递归调用的方式，将产生式变成树中一个路径
     * 从树的根节点开始调用，pos 等于 0，表示
     *
     * @param production
     * @param pos        产生式对应位置
     */
    public void addProductionToTreePath(Production production, int pos) {
        // 首先要将这个产生式添加到当前树节点的产生式列表中
        productions.add(production);

        // 说明 pos 已经是最后的位置了，产生式已经转换完成，直接返回
        if (pos >= production.getRight().size()) {
            return;
        }
        // 获取产生式 production 在 pos 位置的字符
        Symbol symbol = production.getRight().get(pos);

        // 表示该字符 symbol 对应的树节点
        TrieNode symbolNode = null;
        /**
         * 看当前节点的子节点中，包不包含该字符 symbol;
         * 如果包含，就说明有共同前缀的路径，使用这个树节点，将产生式后面的字符，添加到这个树节点另一条路径中
         * 如果不包含，就创建新的树节点，添加到当前节点的子节点列表中，再将产生式后面的字符，添加到这个新树节点路径中
         */
        for (TrieNode child : childList) {
            // 当前节点的符号与产生式对应位置pos 符号相同，那么直接赋值
            if (child.symbol.equals(symbol)) {
                symbolNode = child;
                break;
            }
        }

        // 如果没有找到，那么就创建新的TrieNode
        if (symbolNode == null) {
            /**
             * 这个新节点对应的前缀
             */
            List<Symbol> newPrefixSymbols = new ArrayList<>(prefixSymbols);
            newPrefixSymbols.add(symbol);
            symbolNode = new TrieNode(productionKey, symbol, newPrefixSymbols);
            childList.add(symbolNode);
        }

        /**
         * 通过递归的方式，将 production 剩余字符添加到树的路径中
         */
        symbolNode.addProductionToTreePath(production, pos + 1);
    }
}
