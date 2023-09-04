package com.test.analyze;

/**
 * Author:   lxs
 * Date:     2022/5/19 18:57
 * Description: LR对应的动作
 */
public class Action {

    // 移入
    public static final String TYPE_S = "s";
    // 归约
    public static final String TYPE_R = "r";
    // 终结
    public static final String TYPE_ACC = "acc";

    private final String type;

    // 如果action是移入的时候，stateItemSet代表移入状态，通过stateItemSet的state表示
    private final ProductionItemSet stateItemSet;

    // 当action是归约的时候，production就是归约的产生式
    private final Production production;

    private Action(String type, ProductionItemSet stateItemSet, Production production) {
        this.type = type;
        this.stateItemSet = stateItemSet;
        this.production = production;
    }

    public static Action createAcc() {
        return new Action(TYPE_ACC, null, null);
    }

    public static Action createS(ProductionItemSet stateItemSet) {
        return new Action(TYPE_S, stateItemSet, null);
    }

    public static Action createR(Production production) {
        return new Action(TYPE_R, null, production);
    }

    public boolean isAcc() {
        return TYPE_ACC.equals(type);
    }

    public boolean isS() {
        return TYPE_S.equals(type);
    }

    public boolean isR() {
        return TYPE_R.equals(type);
    }

    public String getType() {
        return type;
    }

    public ProductionItemSet getStateItemSet() {
        return stateItemSet;
    }

    public Production getProduction() {
        return production;
    }

    @Override
    public String toString() {
        if (isAcc()) {
            return "acc";
        }
        if (isR()) {
            return "r->" + production;
        }
        if (isS()) {
            return "s"+stateItemSet.getState();
        }
        return "";
    }
}
