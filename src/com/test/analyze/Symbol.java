package com.test.analyze;

import java.util.Objects;

/**
 * Author:   lxs
 * Date:     2022/5/19 19:02
 * Description: 表示文法中字母表中一个符号，包括终结符和非终结符
 */
public class Symbol implements Comparable<Symbol> {

    public static final String EPSILON = "ε";
    // 文法结束符号
    public static final Symbol END = new Symbol("$", true);
    // 表示符号的值， 这里用 String 表示，而不是 char，
    // 是因为有些符号我们不好用一个 char 表示。 比如 A 对应的 A'
    private final String label;

    private final boolean isTerminator;

    // 外部不能创建
    Symbol(String label, boolean isTerminator) {
        this.label = label;
        this.isTerminator = isTerminator;
    }

    public String getLabel() {
        return label;
    }

    public boolean isTerminator() {
        return isTerminator;
    }

    // 这里只判断 label 值
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        return Objects.equals(label, symbol.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return this.label;
    }

    @Override
    public int compareTo(Symbol o) {
        return label.compareTo(o.label);
    }
}
