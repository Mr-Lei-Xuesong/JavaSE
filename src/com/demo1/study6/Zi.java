package com.demo1.study6;

public class Zi extends Fu {
    public Zi() {
        System.out.println("子类无参构造方法");
    }

    public Zi(int age) {
        super(20);
        System.out.println("子类有参构造方法");
    }
}
