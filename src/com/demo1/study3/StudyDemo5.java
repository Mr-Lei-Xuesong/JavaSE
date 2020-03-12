package com.demo1.study3;

import java.util.Scanner;

public class StudyDemo5 {
    public static void main(String[] args) {
        System.out.println("请输入一串字符串:");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String s = reverse(line);
        System.out.println("反转:" + s);
    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String s1 = sb.toString();
        return s1;
    }
}
