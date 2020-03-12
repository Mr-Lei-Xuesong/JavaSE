package com.demo2.study3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        //从Date 到 String
        Date d = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        String s = sdf1.format(d);
        System.out.println(s);

        System.out.println("--------");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH时:mm分:ss秒");
        String s1 = sdf2.format(d);
        System.out.println(s1);

        //从String 到 Date
        String ss = "1998年09月05日 06时:58分:46秒";
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy年MM月dd日 HH时:mm分:ss秒");
        Date parse = sdf3.parse(ss);
        System.out.println(parse);
    }
}
