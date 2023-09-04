package com.test;

/**
 * Author:   lxs
 * Date:     2022/4/2 16:10
 * Description: 自定义线程类
 */
public class MyRunnable implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            /*synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票,票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }*/
            sellTicket();
        }
    }

    public synchronized void sellTicket() {
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
