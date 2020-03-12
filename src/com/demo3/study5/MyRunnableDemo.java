package com.demo3.study5;

public class MyRunnableDemo {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();

        Thread t1 = new Thread(mr, "高铁");
        Thread t2 = new Thread(mr, "飞机");

        t1.start();
        t2.start();
    }
}
