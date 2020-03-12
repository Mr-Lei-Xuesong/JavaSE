package com.demo2.study2;

public class IntegerString {
    public static void main(String[] args) {
        //int ---> String
        int num = 100;

        //方式一
        String s1 = "" + num;
        System.out.println(s1);

        //方式二
        String s2 = String.valueOf(num);
        System.out.println(s2);

        System.out.println("--------");

        //String ---> int
        String s = "100";

        //方式一
        Integer i1 = Integer.valueOf(s);
        int i = i1.intValue();
        System.out.println(i);

        //方式二
        int i2 = Integer.parseInt(s);
        System.out.println(i2);
    }
}
