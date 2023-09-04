package com.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Author:   lxs
 * Date:     2022/4/25 16:27
 * Description: 日期测试类
 */
public class DateTimeTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("localDate:" + localDate);
        System.out.println("localTime:" + localTime);
        System.out.println("localDateTime:" + localDateTime);

        System.out.println("============");

        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());


        //指定日期时间
        LocalDateTime of = LocalDateTime.of(2022, 4, 25, 16, 30, 40);
        System.out.println(of);
    }
}
