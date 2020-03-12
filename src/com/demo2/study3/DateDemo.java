package com.demo2.study3;

import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println("获取当前时间：" + d);

        System.out.println("--------");
        System.out.println("从标准基准时间1970年1月1日00:00:00距离现在\n" + d.getTime() * 1.0 / 1000 / 60 / 60 / 24 / 365 + "年");

        System.out.println("--------");
        Date d1 = new Date(1000);
        System.out.println("按照标准基准时间1970年1月1日00:00:00算起加上1000毫秒\n" + d1);

        System.out.println("--------");
        long time = 1000 * 60 * 60 * 24;
        d.setTime(time);
        System.out.println("从标准基准时间1970年1月1日00:00:00加上time时间\n" + d);

        System.out.println("--------");
        long now = System.currentTimeMillis();
        d.setTime(now);
        System.out.println("现在的时间" + d);
    }
}
