package com.demo2.study3;

import java.util.Calendar;
import java.util.Date;

public class CalenderDemo {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        int year1 = c.get(Calendar.YEAR);
        int month1 = c.get(Calendar.MONTH) + 1;
        int day1 = c.get(Calendar.DATE);
        System.out.println(year1 + "年" + month1 + "月" + day1 + "日");

        System.out.println("--------");
        c.add(Calendar.YEAR, 10);
        c.add(Calendar.DATE, -8);

        int year2 = c.get(Calendar.YEAR);
        int month2 = c.get(Calendar.MONTH) + 1;
        int day2 = c.get(Calendar.DATE);
        System.out.println(year2 + "年" + month2 + "月" + day2 + "日");

        System.out.println("--------");
        c.set(1998, 8, 05);
        int year3 = c.get(Calendar.YEAR);
        int month3 = c.get(Calendar.MONTH) + 1;
        int day3 = c.get(Calendar.DATE);
        System.out.println(year3 + "年" + month3 + "月" + day3 + "日");
    }
}
