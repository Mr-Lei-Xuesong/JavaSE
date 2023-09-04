package com.test.analyze;

import java.util.Set;

/**
 * Author:   lxs
 * Date:     2022/5/19 19:10
 * Description:
 */
public class SelectSet {

    // 这个可选集对应产生式
    private final Production production;

    // 可选的符号集合
    private final Set<Symbol> set;


    public SelectSet(Production production, Set<Symbol> set) {
        this.production = production;
        this.set = set;
    }

    public Production getProduction() {
        return production;
    }

    public Set<Symbol> getSet() {
        return set;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SelectSet{");
        sb.append("production=").append(production);
        sb.append(", set=").append(set);
        sb.append('}');
        return sb.toString();
    }
}
