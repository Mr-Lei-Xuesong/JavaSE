package com.demo1.study9;

public class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat(String name) {
        System.out.println(name + "吃骨头");
    }

}
