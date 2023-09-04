package com.test.analyze;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:   lxs
 * Date:     2022/5/19 19:08
 * Description:
 */
public class FirstSet {

    /**
     * 这个串首终结符集对应的单个符号，一般都是非终结符。
     * 终结符的串首终结符集就是它自己。
     */
    private final Symbol key;

    /**
     * 这个串首终结符集是否包含 空串
     * 空串ε 不加入到集合中，用hasEpsilon表示这个串首终结符集中有没有空串。
     */
    private boolean hasEpsilon;

    /**
     * 这个字符 key 对应的串首终结符集合
     * 注意这里不包含 ε，ε 我们使用hasEpsilon, 表示是否包含空串
     */
    private Set<Symbol> set = new HashSet<>();

    public FirstSet(Symbol key) {
        this.key = key;
    }

    public void addToSet(Symbol symbol) {
        set.add(symbol);
    }

    public void addAllToSet(Set<Symbol> symbols) {
        set.addAll(symbols);
    }

    public Symbol getKey() {
        return key;
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
        sb.append("FIRST(").append(key).append(") = {");
        set.forEach(symbol -> sb.append(symbol).append("  "));
        if (hasEpsilon) sb.append("ε  ");
        sb.append("}");

        return sb.toString();
    }
}
