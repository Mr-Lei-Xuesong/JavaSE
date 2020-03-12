package com.demo1.study3;

import java.util.Scanner;

public class StudyDemo1 {
    public static void main(String[] args) {
//        scanner();
//        compare();
//        strFor();
//        serca();
        int[] arr = {1, 2, 3, 4};
        String s = forArr(arr);
        System.out.println(s);
    }

    public static void scanner() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String line = sc.nextLine();
        System.out.println("你输入的字符串:" + line);
    }

    public static void compare() {
        String username = "abc";
        String password = "123";
        for (int i = 0; i < 3; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名");
            String name = sc.nextLine();
            System.out.println("请输入密码");
            String pwd = sc.nextLine();
            if (username.equals(name) && password.equals(pwd)) {
                System.out.println("登录成功");
                break;
            } else {
                if (2 - i == 0) {
                    System.out.println("你的账户被锁定");
                } else {
                    System.out.println("登录失败，你还剩" + (2 - i) + "次机会");
                }
            }
        }
    }

    public static void strFor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String line = sc.nextLine();
        for (int i = 0; i < line.length(); i++) {
            System.out.println(line.charAt(i));
        }
    }

    public static void serca() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String line = sc.nextLine();
        int bigCont = 0, smallCont = 0, numCont = 0, space = 0;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                bigCont++;
            } else if (ch >= 'a' && ch <= 'z') {
                smallCont++;
            } else if (ch >= '0' && ch <= '9') {
                numCont++;
            } else if (ch == ' ') {
                space++;
            }
        }
        System.out.println("大写字母:" + bigCont + "小写字母:" + smallCont + "数字:" + numCont + "空格:" + space);
    }

    public static String forArr(int[] arr) {
        String s = "";
        s += "[";
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                s += arr[i];
            } else {
                s += arr[i];
                s += ", ";
            }

        }
        s += "]";
        return s;
    }
}
