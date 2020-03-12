package com.demo1.study2;

import java.util.Scanner;

/*
递归方法
 */
public class DemoStudy02 {
    public static void main(String[] args) {
        System.out.print("请输入数字:");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int sum = digui(i);
        System.out.println(sum);
        DemoStudy03 D3 = new DemoStudy03();
        DemoStudy03 D1 = new DemoStudy03("雷雪松", 20);
    }

    public static int digui(int i) {
        if (i == 1) {
            return 1;
        } else {
            return i * digui(i - 1);
        }
    }
}
