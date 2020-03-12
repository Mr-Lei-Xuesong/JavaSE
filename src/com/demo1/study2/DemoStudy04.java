package com.demo1.study2;

import java.util.Random;
import java.util.Scanner;

/*
判断奇偶数
 */
public class DemoStudy04 {
    public static void main(String[] args) {
        Random();
        SuiJi();
    }

    public static void Random() {
        System.out.println("下面是随机数");
        Random random = new Random();
        int number = random.nextInt(10);
        System.out.println(number);
    }

    public static void SuiJi() {
        System.out.println("请输入一个数字");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if (i % 2 == 0) {
            System.out.println(i + "是偶数");
        } else {
            System.out.println(i + "是奇数");
        }
    }
}
