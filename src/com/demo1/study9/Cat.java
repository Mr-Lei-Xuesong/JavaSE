package com.demo1.study9;

public class Cat extends Animal {
    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat(String name) {
        System.out.println(name + "吃鱼");
    }

}
