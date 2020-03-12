package com.demo1.study2;

/*
构造方法
 */
public class DemoStudy03 {
    private String name;
    private int age;

    public DemoStudy03() {
        System.out.println("这是无参构造方法");
    }

    public DemoStudy03(String name, int age) {
        System.out.println("这是有参构造方法");
        this.age = age;
        this.name = name;
        System.out.println("我的名字:" + name + "我的年龄:" + age);
    }
}
