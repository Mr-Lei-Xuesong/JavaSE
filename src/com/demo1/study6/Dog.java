package com.demo1.study6;

public class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    public void kanmen(String name) {
        System.out.println(name + "在看门");
    }
}
