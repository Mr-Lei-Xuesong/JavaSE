package com.demo1.study6;

public class AnimalDemo {
    public static void main(String[] args) {
        Cat c1 = new Cat();
        c1.setName("加菲猫");
        c1.setAge(5);
        System.out.println(c1.getName() + ", " + c1.getAge());
        c1.zhuashu(c1.getName());

        System.out.println("--------------");
        Cat c2 = new Cat("肥猫", 6);
        System.out.println(c2.getName() + ", " + c2.getAge());
        c2.zhuashu(c2.getName());

        System.out.println("--------------");
        Dog d1 = new Dog();
        d1.setName("哈士奇");
        d1.setAge(4);
        System.out.println(d1.getName() + ", " + d1.getAge());
        d1.kanmen(d1.getName());

        System.out.println("--------------");
        Dog d2 = new Dog("泰迪", 7);
        System.out.println(d2.getName() + ", " + d2.getAge());
        d2.kanmen(d2.getName());
    }
}
