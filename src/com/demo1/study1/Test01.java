package com.demo1.study1;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
//        test1();
//        feng7();
//        noDeathTu();
//        baiJi();
        arrySum();
    }

    public static void test1() {
        System.out.println("请输入星期几:");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        switch (x) {
            case 1:
                System.out.println("跑步");
                break;
            case 2:
                System.out.println("游泳");
                break;
            case 3:
                System.out.println("慢走");
                break;
            case 4:
                System.out.println("动感单车");
                break;
            case 5:
                System.out.println("拳击");
                break;
            case 6:
                System.out.println("爬山");
                break;
            case 7:
                System.out.println("好好吃一顿");
                break;
            default:
                System.out.println("啥都不做");
        }
        System.out.println("今天星期:" + x);
    }

    public static void feng7() {
        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 7 || i / 10 % 10 == 7 || i % 7 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void noDeathTu() {
        int[] rab = new int[20];
        rab[0] = 1;
        rab[1] = 1;
        for (int i = 2; i < rab.length; i++) {
            rab[i] = rab[i - 1] + rab[i - 2];
        }
        System.out.println("第二十个月兔子有:" + rab[19]);
    }

    public static void baiJi() {
        for (int x = 0; x <= 20; x++) {
            for (int y = 0; y <= 33; y++) {
                int z = 100 - x - y;
                if (x % 3 == 0 && 5 * x + 3 * y + z / 3 == 100) {
                    System.out.println("x: " + x + " y:" + y + " z:" + z);
                }
            }
        }
    }

    public static void arrySum() {
        int[] arr = {68, 27, 95, 88, 171, 996, 21, 210};
        int sum = 0;
        for (int x : arr) {
            if (x % 10 != 1 && x / 10 % 10 != 7 && x % 2 == 0) {
                sum += x;
            }
        }
        System.out.println(sum);
    }
}
