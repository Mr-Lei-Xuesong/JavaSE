package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Author:   xuesong.lei
 * Date:     2022/10/31 20:35
 * Description:
 */
public class ScheduledTest {
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date("2022-10-31 20:45:27");
        System.out.println(date);
    }

    private static void scheduled() throws InterruptedException {
        System.out.println("开始时间"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(5);
        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
                System.out.println("结束时间"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            }
        }, 10, TimeUnit.SECONDS);
        Thread.sleep(10000);
    }
}
