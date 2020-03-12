package com.demo2.study3;

import java.util.Calendar;
import java.util.Scanner;

/*
键盘输入年份，查询输入年份2月有多少天
 */
public class CalenderTest {
    public static void main(String[] args) {
        System.out.println("请输入年份:");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        Calendar c = Calendar.getInstance();
        c.set(year, 2, 1);
        c.add(Calendar.DATE, -1);
        int i = c.get(Calendar.DATE);
        System.out.println(year + "年,二月份有" + i + "天");
    }
}
