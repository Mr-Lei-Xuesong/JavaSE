package com.demo3.study10;

public interface Inter {
    void test1();

    default void show1(){
        System.out.println("show1被执行了");
    }

    static void look1(){
        System.out.println("look1被执行了");
    }
}
