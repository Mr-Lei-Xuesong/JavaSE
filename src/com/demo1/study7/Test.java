package com.demo1.study7;

public class Test {
    public static void main(String[] args) {
        DemoAnimal a = new DemoAnimal();
        Cat c = new Cat();
        a.demoAnimal(c);

        Dog d = new Dog();
        a.demoAnimal(d);

        Pig p = new Pig();
        a.demoAnimal(p);
    }
}
