package com.test;

/**
 * @Author: xuesong.lei
 * @Date: 2023/8/18 9:41
 * @Description:
 */
public class ThreadDemo {

    private int x, y;
    private int a, b;

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.test();

    }

    public void test() {
        Thread t1 = new Thread(() -> {
            a = 1;
            x = b;
        });
        Thread t2 = new Thread(() -> {
            b = 2;
            y = a;
        });
        t1.start();
        t2.start();
        // join等待线程
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert x == 2;
        assert y == 1;
    }
}
