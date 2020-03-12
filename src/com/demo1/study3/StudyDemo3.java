package com.demo1.study3;

import java.util.Scanner;

public class StudyDemo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串字符串:");
        String line = sc.nextLine();
        System.out.println("反转的字符串:" + reverse(line));
        System.out.println("==============");
        String s = "雷雪松";
        boolean ends = s.endsWith("松");
        System.out.println(ends);
    }

    public static String reverse(String s) {
        String ss = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            ss += s.charAt(i);
        }
        return ss;
    }
}
