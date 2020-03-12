package com.demo1.study9;

public class DemoAnimal {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.setName("加菲猫");
        a.setAge(5);
        System.out.println(a.getName() + ", " + a.getAge());
        a.eat(a.getName());
        a.paly(a.getName());

        System.out.println("--------");
        a = new Cat("肥波猫", 4);
        System.out.println(a.getName() + ", " + a.getAge());
        a.eat(a.getName());
        a.paly(a.getName());

        System.out.println("--------");
        a = new Dog();
        a.setName("哈士奇");
        a.setAge(6);
        System.out.println(a.getName() + ", " + a.getAge());
        a.eat(a.getName());

        System.out.println("--------");
        a = new Dog("泰迪", 3);
        System.out.println(a.getName() + ", " + a.getAge());
        a.eat(a.getName());
    }
}
