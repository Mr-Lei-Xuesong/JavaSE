package com.demo3.study5;

public class MyThreadDemo {
    public static void main(String[] args) {
        MyThread m1 = new MyThread("火车");
        MyThread m2 = new MyThread("飞机");

//        m1.setName("测试");

//        System.out.println(m1.getPriority());
//        System.out.println(m2.getPriority());
//        System.out.println(Thread.MAX_PRIORITY);
//        System.out.println(Thread.MIN_PRIORITY);
//        System.out.println(Thread.NORM_PRIORITY);
        m1.setPriority(1);
        m2.setPriority(10);

        m1.start();
        m2.start();
    }
}
