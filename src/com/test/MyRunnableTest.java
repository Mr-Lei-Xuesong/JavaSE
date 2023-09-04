package com.test;

/**
 * Author:   lxs
 * Date:     2022/4/2 16:12
 * Description: 自定义线程类测试类
 */
public class MyRunnableTest {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        new Thread(myRunnable,"窗口1").start();
        new Thread(myRunnable,"窗口2").start();
        new Thread(myRunnable,"窗口3").start();
    }
}
