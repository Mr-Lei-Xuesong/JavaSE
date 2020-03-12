package com.demo1.study1;

public class Demo {
    public String name;
    public int age;

    public Demo() {
        System.out.println("调用了无参构造方法");
    }

    public Demo(String name) {
        this();
        this.name = name;
        System.out.println(name + "在玩");
    }

    public Demo(String name, int age) {
        this("曾玉梅");
        this.name = name;
        this.age = age;
        System.out.println(name + ", " + age);
    }
}
