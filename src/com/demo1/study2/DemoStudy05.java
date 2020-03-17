package com.demo1.study2;
/*
判断最大/最小值
 */
public class DemoStudy05 {
    public static void main(String[] args) {
        /*maxArray();
        minArray();
        maxMath();*/
        int a = 10, b = 15;
        int max = getMax(a, b);
        System.out.println(max);
    }

    public static int getMax(int a, int b) {
        int max = a > b ? a : b;
        return max;
    }

    public static void maxArray() {
        int[] arr = new int[]{10, 85, 96, 34, 56, 74};
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("最大值是:" + max);
    }

    public static void maxMath() {
        int a = 2, b = 3;
        int bj = a > b ? a : b;
        System.out.println(bj);
    }

    public static void minArray() {
        int[] arr = new int[]{10, 85, 96, 34, 56, 74};
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("最小值是:" + min);
    }
}
