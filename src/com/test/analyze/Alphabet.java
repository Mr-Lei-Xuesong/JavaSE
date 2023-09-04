package com.test.analyze;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:   lxs
 * Date:     2022/5/19 19:07
 * Description:
 */
public class Alphabet {

    /**
     * 字母表中所有的符号
     */
    public static final Map<String, Symbol> ALL_SYMBOL = new HashMap<>();

    // 初始化
    static {
        for (int index = 0; index <= 9; index++) {
            ALL_SYMBOL.put("" + index, new Symbol("" + index, true));
        }
        // a-z
        for (char ch = 97; ch <= 122; ch++) {
            ALL_SYMBOL.put(String.valueOf(ch), new Symbol(String.valueOf(ch), true));
        }
        // A - Z
        for (char ch = 65; ch <= 90; ch++) {
            ALL_SYMBOL.put(String.valueOf(ch), new Symbol(String.valueOf(ch), false));
        }
        ALL_SYMBOL.put("+", new Symbol("+", true));
        ALL_SYMBOL.put("-", new Symbol("-", true));
        ALL_SYMBOL.put("*", new Symbol("*", true));
        ALL_SYMBOL.put("(", new Symbol("(", true));
        ALL_SYMBOL.put(")", new Symbol(")", true));
    }

    public static Symbol addSymbol(char ch) {
        return addSymbol(ch, true);
    }

    public static Symbol addSymbol(char ch, boolean isTerminator) {
        return addSymbol(String.valueOf(ch), isTerminator);
    }

    public static Symbol addSymbol(String label) {
        return addSymbol(label, true);
    }

    public static Symbol addSymbol(String label, boolean isTerminator) {
        Symbol symbol = new Symbol(label, isTerminator);
        ALL_SYMBOL.put(label, symbol);
        return symbol;
    }

    public static Symbol getSymbol(char ch) {
        return getSymbol(String.valueOf(ch));
    }

    public static Symbol getSymbol(String label) {
        return ALL_SYMBOL.get(label);
    }

}
