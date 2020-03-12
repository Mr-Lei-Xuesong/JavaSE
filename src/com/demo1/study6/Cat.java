package com.demo1.study6;

public class Cat extends Animal {
    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    public void zhuashu(String name) {
        System.out.println(name + "抓老鼠");
    }
}
