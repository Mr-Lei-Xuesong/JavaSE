package com.test;

/**
 * Author:   lxs
 * Date:     2022/4/2 16:07
 * Description: 自定义线程测试类
 */
public class MyThreadTest {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();

        myThread1.setName("窗口1");
        myThread2.setName("窗口2");
        myThread3.setName("窗口3");

        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}



