package com.test.analyze;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author:   lxs
 * Date:     2022/5/19 19:08
 * Description:
 */
public class FirstsSet {

    /**
     * 当前的文法符号串
     */
    private final List<Symbol> keys;

    /**
     * 这个串首终结符集是否包含 空串
     */
    private boolean hasEpsilon;

    /**
     * 字符 key 对应的串首终结符集合
     * 注意这里不包含 ε，ε 我们使用hasEpsilon, 表示是否包含空串
     */
    private Set<Symbol> set = new HashSet<>();

    public FirstsSet(List<Symbol> keys) {
        this.keys = keys;
    }

    public void addToSet(Symbol symbol) {
        set.add(symbol);
    }

    public void addAllToSet(Set<Symbol> symbols) {
        set.addAll(symbols);
    }

    public List<Symbol> getKeys() {
        return keys;
    }

    public boolean isHasEpsilon() {
        return hasEpsilon;
    }

    public void setHasEpsilon(boolean hasEpsilon) {
        this.hasEpsilon = hasEpsilon;
    }

    public Set<Symbol> getSet() {
        return set;
    }

    public void setSet(Set<Symbol> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FIRST(").append(keys).append(") = {");
        set.forEach(symbol -> sb.append(symbol).append("  "));
        if (hasEpsilon) sb.append("ε  ");
        sb.append("}");

        return sb.toString();
    }
}
