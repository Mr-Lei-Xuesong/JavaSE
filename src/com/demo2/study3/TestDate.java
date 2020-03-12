package com.demo2.study3;

import java.text.ParseException;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        String s1 = DateUtils.dateToString(date, "yyyy年MM月dd日 HH时:mm分:ss秒");
        System.out.println(s1);

        System.out.println("--------");
        String ss = "1998年09月05日 08时:00分:00秒";
        Date toDate = DateUtils.stringToDate(ss, "yyyy年MM月dd日 HH时:mm分:ss秒");
        System.out.println(toDate);
    }
}
