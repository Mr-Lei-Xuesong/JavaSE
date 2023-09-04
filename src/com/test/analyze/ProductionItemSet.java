package com.test.analyze;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Author:   lxs
 * Date:     2022/5/19 18:58
 * Description:
 */
public class ProductionItemSet {

    /**
     * 记录所有创建过的项目集
     */
    public static final Map<String, ProductionItemSet> allItemSetMap = new HashMap<>();

    private static int stateGenerate = 0;

    /**
     * 当前项目集对应的状态
     */
    private final int state;

    /**
     * 项目的集合
     */
    private final Set<ProductionItem> itemSet;

    /**
     * 项目集的label，用来它来判断两个项目集是否相等
     */
    private final String label;

    private ProductionItemSet(int state, Set<ProductionItem> itemSet, String label) {
        this.state = state;
        this.itemSet = itemSet;
        this.label = label;
    }

    public static ProductionItemSet create(Set<ProductionItem> items) {
        StringBuilder sb = new StringBuilder();
        // 这里必须进行排序，才能比较两个
        items.stream().sorted().forEach(item -> sb.append(item.getLabel()).append(","));
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        String label = sb.toString();
        /**
         * 如果 label 相同，说明是同一个项目集，那么返回之前创建的；
         * 保证相同 items 的是返回的是同一个 ProductionItemSet
         */
        ProductionItemSet itemSet = allItemSetMap.get(label);
        if (itemSet == null) {
            itemSet = new ProductionItemSet(stateGenerate++, items, sb.toString());
            allItemSetMap.put(label, itemSet);
        }
        return itemSet;
    }

    public Set<ProductionItem> getItemSet() {
        return itemSet;
    }

    public String getLabel() {
        return label;
    }

    public int getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductionItemSet that = (ProductionItemSet) o;
        return label.equals(that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return state + "==" + label;
    }
}
