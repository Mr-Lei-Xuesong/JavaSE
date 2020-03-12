package com.demo1.study6;

public class Father extends GrandDad {
    public void smoke() {
        System.out.println("爸爸爱抽烟");
    }

    @Override
    public void drink() {
        super.drink();
        System.out.println("爸爸也爱喝酒");
    }
}
