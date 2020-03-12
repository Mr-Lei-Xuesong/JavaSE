package com.demo1.study6;

public class Son extends Father {
    public void me() {
        System.out.println("我爱玩");
    }

    @Override
    public void drink() {
        super.drink();
        System.out.println("我也爱喝酒");
    }

    @Override
    public void smoke() {
        super.smoke();
        System.out.println("我也爱抽烟");
    }
}
