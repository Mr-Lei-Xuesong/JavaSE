package com.test.analyze;

import java.util.Objects;

/**
 * Author:   lxs
 * Date:     2022/5/19 18:57
 * Description:
 */
public class ProductionItem implements Comparable<ProductionItem> {
    public static final String ITEM_SYMBOL = "•";

    /**
     * 项目对应的产生式
     */
    private final Production production;

    /**
     * 表示当前项目对应的位置，即圆点的位置。
     */
    private final int pos;

    /**
     * 表示当前pos位置对应的字符。
     * 例:产生式 S -> bBB
     * 它有四个项目         •bBB b•BB  bB•B  bBB•
     * pos 位置分别是        0    1     2    3
     * 对应的posSymbol就是   b    B     B    Symbol.END
     */
    private final Symbol posSymbol;

    /**
     * 这个产生式项目的标签
     * 例如 •bBB b•BB bB•B bBB•
     * 也是这个产生式项目是否相等判断的依据
     */
    private final String label;

    private ProductionItem(Production production, int pos, Symbol posSymbol, String label) {
        this.production = production;
        this.pos = pos;
        this.posSymbol = posSymbol;
        this.label = label;
    }

    /**
     * 创建产生式对应的移进项目
     *
     * @param production
     * @return
     */
    public static ProductionItem createProduction(Production production) {
        return create(production, 0);
    }

    /**
     * 创建当前项目 item 的后继项目
     *
     * @param item
     * @return
     */
    public static ProductionItem nextByItem(ProductionItem item) {
        return create(item.production, item.pos + 1);
    }

    private static ProductionItem create(Production production, int pos) {
        StringBuilder sb = new StringBuilder();
        Symbol posSymbol = null;
        for (int index = 0; index < production.getRight().size(); index++) {
            Symbol symbol = production.getRight().get(index);
            if (index == pos) {
                posSymbol = symbol;
                sb.append(ITEM_SYMBOL);
            }
            sb.append(symbol.getLabel());
        }
        if (pos == production.getRight().size()) {
            posSymbol = Symbol.END;
            sb.append(ITEM_SYMBOL);
        }
        return new ProductionItem(production, pos, posSymbol, sb.toString());
    }

    public Production getProduction() {
        return production;
    }

    public int getPos() {
        return pos;
    }

    public Symbol getPosSymbol() {
        return posSymbol;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductionItem that = (ProductionItem) o;
        return label.equals(that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public int compareTo(ProductionItem o) {
        return label.compareTo(o.label);
    }
}
