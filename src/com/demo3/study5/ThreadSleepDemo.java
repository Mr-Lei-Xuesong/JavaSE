package com.demo3.study5;

public class ThreadSleepDemo {
    public static void main(String[] args) {
        ThreadSleep td1 = new ThreadSleep();
        ThreadSleep td2 = new ThreadSleep();
        ThreadSleep td3 = new ThreadSleep();

        td1.setName("刘备");
        td2.setName("孙权");
        td3.setName("曹操");

        td1.start();
        td2.start();
        td3.start();
    }
}
