package com.demo1.study2;

/*
方法重载
 */
public class DemoStudy01 {
    public static void main(String[] args) {
        int i = 20;
        int j = 50;
        int l = 10;
        int sum1 = add(i, j);
        int sum2 = add(i, j, l);
        int sum3 = add(i);
        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
    }

    public static int add(int i, int j) {
        int sum = i * j;
        return sum;
    }

    public static int add(int i, int j, int l) {
        int sum = i + j + l;
        return sum;
    }

    public static int add(int i) {
        int sum = i * i;
        return sum;
    }
}
