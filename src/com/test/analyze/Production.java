package com.test.analyze;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:   lxs
 * Date:     2022/5/19 19:03
 * Description:
 */
public class Production {

    public static final List<Symbol> EMPTY = new ArrayList<>(0);
    /**
     * 产生式左边，而且必须是非终结符
     */
    private final Symbol left;

    /**
     * 这里的 List<Symbol> 希望是不可变的，你们可以自己引入 ImmutableList
     */
    private final List<Symbol> right;

    /**
     * 表示这个产生式是不是左递归产生式
     */
    private final boolean isLeftEliminate;

    public Production(Symbol left, List<Symbol> right, boolean isLeftEliminate) {
        this.left = left;
        this.right = right;
        this.isLeftEliminate = isLeftEliminate;
    }

    public static List<Production> createList(Symbol left, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new RuntimeException("str cannot be null");
        }
        List<Production> productions = new ArrayList<>();
        for (String str : strArr) {
            if (Symbol.EPSILON.equals(str)) {
                productions.add(createEmpty(left));
            } else {
                productions.add(create(left, str));
            }
        }
        return productions;
    }

    // 生成空产生式
    public static Production createEmpty(Symbol left) {
        return new Production(left, EMPTY, false);
    }

    public static Production create(Symbol left, String str) {
        if (str == null || str.isEmpty()) {
            throw new RuntimeException("str cannot be null");
        }
        List<Symbol> symbolList = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            symbolList.add(Alphabet.getSymbol(ch));
        }

        return create(left, symbolList);
    }

    public static Production create(Symbol left, List<Symbol> symbols) {
        if (symbols == null || symbols.isEmpty()) {
            throw new RuntimeException("str cannot be null");
        }
        // 产生式左部 与 产生式第一个字母相等，表示它是一个直接递归的产生式。
        boolean isLeftEliminate = left.equals(symbols.get(0));
        return new Production(left, symbols, isLeftEliminate);
    }

    /**
     * 例如   P -> Pa|Pb|Pc|Pd|e|f|g|h 变成  P -> eP'|fP'|gP'|hP'
     * 这里 就是 e 变成 eP'
     *
     * @return
     */
    public List<Symbol> addSymbolToRight(Symbol newKey) {
        // 新创建一个 newRight , 为了不修改 right
        List<Symbol> newRight = new ArrayList<>(right);
        newRight.add(newKey);
        return newRight;
    }

    /**
     * 例如   P -> Pa|Pb|Pc|Pd|e|f|g|h 变成  p'-> aP'|bP'|cP'|dP'|ε
     * 这里 就是 Pa 变成 aP'
     *
     * @param newKey
     * @return
     */
    public List<Symbol> addSymbolToRightAndRemoveFirst(Symbol newKey) {
        // 新创建一个 newRight , 为了不修改 right
        List<Symbol> newRight = new ArrayList<>(right);
        newRight.add(newKey);
        newRight.remove(0);
        return newRight;
    }

    /**
     * 替换产生式第一个字符变成 other.right
     * 为了消除间接左递归
     * S -> Aa|b   A -> Ac|Sd
     * 变为 A -> Ac|Aad|bd
     * <p>
     * Sd 变成 Aad 和 bd
     *
     * @param other
     * @return
     */
    public List<Symbol> replaceRightFirst(Production other) {
        List<Symbol> newRight = new ArrayList<>(other.right);
        newRight.addAll(right);
        // 删除 第一个字符
        newRight.remove(other.right.size());
        return newRight;
    }

    /**
     * 得到产生式右部第一个字符
     * 用来判断间接左递归
     *
     * @return
     */
    public Symbol getRightFirst() {
        if (right.isEmpty()) {
            return null;
        }
        return right.get(0);
    }

    public boolean isEpsilon() {
        return right.isEmpty();
    }

    public boolean isLeftEliminate() {
        return isLeftEliminate;
    }

    public Symbol getLeft() {
        return left;
    }

    public List<Symbol> getRight() {
        return right;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(left).append("->");
        for (Symbol symbol : right) {
            sb.append(symbol.getLabel());
        }
        if (isEpsilon()) {
            sb.append('ε');
        }
        return sb.toString();
    }
}
