package com.test.analyze;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:   lxs
 * Date:     2022/5/19 19:08
 * Description:
 */
public class FollowSet {

    /**
     * 当前 Follow集对应的字母, 必须是非终结符；
     * 终结符不可能有Follow集
     */
    private final Symbol key;

    /**
     * 非终结符 key 对应的Follow集
     */
    private Set<Symbol> set = new HashSet<>();

    public FollowSet(Symbol key) {
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

    public Set<Symbol> getSet() {
        return set;
    }

    public void setSet(Set<Symbol> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Follow(");
        sb.append(key).append(") = {");
        set.forEach(symbol -> sb.append(symbol).append("  "));
        sb.append('}');
        return sb.toString();
    }
}
