package com.demo3.study10;

public interface Outer {
    void test2();

    default void show2(){
        System.out.println("show2被执行了");
    }

    static void look2(){
        System.out.println("look2被执行了");
    }
}
