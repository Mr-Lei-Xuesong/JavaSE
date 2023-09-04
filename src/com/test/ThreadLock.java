package com.test;

public class ThreadLock {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        new Thread(() -> {
            synchronized (a) {
                System.out.println("get a");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (b) {
                    System.out.println("want get b");
                }
            }
        }, "a").start();

        new Thread(() -> {
            synchronized (b) {
                System.out.println("get b");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (a) {
                    System.out.println("want get a");
                }
            }
        }, "b").start();
    }
}
