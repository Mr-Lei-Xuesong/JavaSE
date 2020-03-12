package com.demo1.study10;

public class AnimalDemo {
    public static void main(String[] args) {
        Jumpping j1 = new Cat();
        j1.jump();

        System.out.println("-------");
        Jumpping j2 = new Dog();
        j2.jump();

        System.out.println("-------");
        Animal a1 = new Cat();
        a1.setName("加菲猫");
        a1.setAge(5);
        System.out.println(a1.getName() + ", " + a1.getAge());
        a1.eat();
//        a1.jump();

        System.out.println("-------");
        a1 = new Cat("肥猫", 6);
        System.out.println(a1.getName() + ", " + a1.getAge());
        a1.eat();

        System.out.println("-------");
        Animal a2 = new Dog();
        a2.setName("哈士奇");
        a2.setAge(10);
        System.out.println(a2.getName() + ", " + a2.getAge());
        a2.eat();
//        a2.jump();

        System.out.println("-------");
        a2 = new Dog("泰迪", 7);
        System.out.println(a2.getName() + ", " + a2.getAge());
        a2.eat();

        System.out.println("--------");
        Cat c = new Cat();
        c.setName("波斯猫");
        c.setAge(8);
        System.out.println(c.getName() + ", " + c.getAge());
        c.eat();
        c.jump();

        System.out.println("--------");
        Dog d = new Dog();
        d.setName("金毛犬");
        d.setAge(2);
        System.out.println(d.getName() + ", " + d.getAge());
        d.eat();
        d.jump();
    }
}
