package com.demo1.study1;

public class TestDemo {
    public static void main(String[] args) {
        Demo d1 = new Demo();
        System.out.println(d1.age);
        System.out.println(d1.name);

        System.out.println("--------");
        Demo d2 = new Demo("雷雪松");
        System.out.println(d2.age);
        System.out.println(d2.name);

        System.out.println("--------");
        Demo d = new Demo("雷小松", 18);
        System.out.println(d.age);
        System.out.println(d.name);
    }
}
