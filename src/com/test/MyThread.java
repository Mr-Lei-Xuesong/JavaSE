package com.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:   lxs
 * Date:     2022/4/2 16:03
 * Description: 自定义线程
 */
public class MyThread extends Thread {

    private static int ticket = 100;

//    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            /*synchronized (MyThread.class) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ":卖票,票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }*/
            sellTicket();
        }
    }

    public static synchronized void sellTicket() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票,票号为：" + ticket);
            ticket--;
        }
    }

}
