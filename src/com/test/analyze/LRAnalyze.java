package com.test.analyze;

import java.util.*;

/**
 * Author:   lxs
 * Date:     2022/5/19 19:15
 * Description: LR分析器
 */
public class LRAnalyze {

    private static Set<ProductionItem> closure(Set<ProductionItem> items, Grammar grammar) {
        Set<ProductionItem> resultItems = new HashSet<>(items);
        Stack<ProductionItem> stack = new Stack<>();
        stack.addAll(items);
        while (!stack.isEmpty()) {
            ProductionItem item = stack.pop();
            if (!item.getPosSymbol().isTerminator()) {
                List<Production> productionList = grammar.getProductionsMap()
                        .get(item.getPosSymbol());
                for (Production production : productionList) {
                    ProductionItem newItem = ProductionItem.createProduction(production);
                    if (!resultItems.contains(newItem)) {
                        resultItems.add(newItem);
                        stack.push(newItem);
                    }
                }
            }
        }
        return resultItems;
    }

    private static final Map<ProductionItemSet, Map<Symbol, ProductionItemSet>> GOTO_TABLE = new HashMap<>();

    static ProductionItemSet Goto(ProductionItemSet itemSet, Symbol symbol, Grammar grammar) {
        if (GOTO_TABLE.containsKey(itemSet)) {
            Map<Symbol, ProductionItemSet> map = GOTO_TABLE.get(itemSet);
            if (map.containsKey(symbol)) {
                return map.get(symbol);
            }
        }
        Set<ProductionItem> nextItems = new HashSet<>();
        for (ProductionItem item : itemSet.getItemSet()) {
            if (item.getPosSymbol().equals(symbol)) {
                nextItems.add(ProductionItem.nextByItem(item));
            }
        }
        if (nextItems.isEmpty()) {
            return null;
        }
        ProductionItemSet gotoItemSet = ProductionItemSet.create(closure(nextItems, grammar));
        Utils.addToDoubleMap(GOTO_TABLE, itemSet, symbol, gotoItemSet);
        return gotoItemSet;
    }

    private static List<ProductionItemSet> getAllItemSet(Grammar grammar) {
        Set<Symbol> allSymbol = grammar.getAllSet();
        Symbol start = grammar.getStart();
        Production startProduction = grammar.getProductionsMap().get(start).get(0);
        ProductionItem startItem = ProductionItem.createProduction(startProduction);
        ProductionItemSet startItemSet = ProductionItemSet.create(closure(Utils.asSet(startItem), grammar));
        List<ProductionItemSet> allItemSetList = new ArrayList<>();
        allItemSetList.add(startItemSet);
        Stack<ProductionItemSet> stack = new Stack<>();
        stack.push(startItemSet);
        while (!stack.isEmpty()) {
            ProductionItemSet itemSet = stack.pop();
            for (Symbol eachSymbol : allSymbol) {
                ProductionItemSet gotoItemSet = Goto(itemSet, eachSymbol, grammar);
                if (gotoItemSet != null && !allItemSetList.contains(gotoItemSet)) {
                    allItemSetList.add(gotoItemSet);
                    stack.push(gotoItemSet);
                }
            }
        }
        return allItemSetList;
    }

    private static void createLR0Table(Grammar grammar, List<ProductionItemSet> allItemSetList,
                                       Map<ProductionItemSet, Map<Symbol, Action>> actionMap,
                                       Map<ProductionItemSet, Map<Symbol, ProductionItemSet>> gotoMap) {
        Symbol start = grammar.getStart();
        Set<Symbol> vtSymbols = grammar.getVtSet();
        vtSymbols.add(Symbol.END);
        for (ProductionItemSet itemSet : allItemSetList) {
            for (ProductionItem item : itemSet.getItemSet()) {
                Symbol posSymbol = item.getPosSymbol();
                if (!posSymbol.isTerminator()) {
                    Utils.addToDoubleMapPrintConflict(gotoMap, itemSet, posSymbol, LRAnalyze.Goto(itemSet, posSymbol, grammar),
                            "gotoMap 有冲突: old: %s, new: %s");
                } else {
                    if (!Symbol.END.equals(posSymbol)) {
                        ProductionItemSet nextItemSet = LRAnalyze.Goto(itemSet, posSymbol, grammar);
                        Utils.addToDoubleMapPrintConflict(actionMap, itemSet, posSymbol, Action.createS(nextItemSet),
                                "actionMap 有冲突: old: %s,  new: %s");
                    } else {
                        Production production = item.getProduction();
                        if (start.equals(production.getLeft())) {
                            Utils.addToDoubleMapPrintConflict(actionMap, itemSet, posSymbol, Action.createAcc(),
                                    "actionMap 有冲突: old: %s,  new: %s");
                        } else {
                            for (Symbol symbol : vtSymbols) {
                                Utils.addToDoubleMapPrintConflict(actionMap, itemSet, symbol, Action.createR(production),
                                        "actionMap 有冲突: old: %s,  new: %s");
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean match(List<Symbol> inputSymbols, ProductionItemSet startState,
                                 Map<ProductionItemSet, Map<Symbol, Action>> actionMap,
                                 Map<ProductionItemSet, Map<Symbol, ProductionItemSet>> gotoMap) {
        List<Production> matchProductions = new ArrayList<>();
        Stack<ProductionItemSet> stateStack = new Stack<>();
        stateStack.push(startState);
        Stack<Symbol> symbolStack = new Stack<>();
        symbolStack.push(Symbol.END);
        int inputPos = 0;
        while (true) {
            ProductionItemSet currentItemSet = stateStack.peek();
            Symbol inputSymbol = inputSymbols.get(inputPos);
            Action action = actionMap.get(currentItemSet).get(inputSymbol);
            if (action.isAcc()) {
                if (inputPos == inputSymbols.size() - 1) {
                    System.out.println("匹配成功");
                    System.out.println(matchProductions);
                    return true;
                }
                System.out.println("匹配失败");
                System.out.println(matchProductions);
                return false;
            } else if (action.isS()) {
                stateStack.push(action.getStateItemSet());
                symbolStack.push(inputSymbol);
                inputPos++;
            } else if (action.isR()) {
                Production production = action.getProduction();
                int size = production.getRight().size();
                List<Integer> popStateList = new ArrayList<>();
                List<Symbol> popSymbol = new ArrayList<>();
                for (int index = 0; index < size; index++) {
                    popStateList.add(stateStack.pop().getState());
                    popSymbol.add(symbolStack.pop());
                }
                System.out.println("popStateList: " + popStateList + "  popSymbol:" + popSymbol + "  production:" + production);
                matchProductions.add(production);
                symbolStack.push(production.getLeft());
                ProductionItemSet itemSet = gotoMap.get(stateStack.peek()).get(production.getLeft());
                stateStack.push(itemSet);
            } else {
                throw new RuntimeException("匹配错误");
            }
        }
    }

    public static void main(String[] agrs) {
        Symbol start = Alphabet.addSymbol("S'");
        Grammar grammar = Grammar.create(start,
                Production.create(start, "S"),
                Production.create(Alphabet.getSymbol("S"), "LS"),
                Production.create(Alphabet.getSymbol("S"), "L"),
                Production.create(Alphabet.getSymbol("L"), "x"),
                Production.create(Alphabet.getSymbol("L"), "y")
        );
        List<ProductionItemSet> allItemSetList = getAllItemSet(grammar);
        System.out.println(allItemSetList);

        Map<ProductionItemSet, Map<Symbol, Action>> actionMap = new HashMap<>();
        Map<ProductionItemSet, Map<Symbol, ProductionItemSet>> gotoMap = new HashMap<>();
        createLR0Table(grammar, allItemSetList, actionMap, gotoMap);

        List<Symbol> inputSymbols = Utils.createSymbolsByString("xyx");
        inputSymbols.add(Symbol.END);
        match(inputSymbols, allItemSetList.get(0), actionMap, gotoMap);
    }
}
