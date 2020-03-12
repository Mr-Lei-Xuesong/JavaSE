package com.demo2.study1;

public class MathDemo {
    public static void main(String[] args) {
        //public static int abs(int a);返回绝对值
        System.out.println(Math.abs(-80));
        System.out.println(Math.abs(80));

        System.out.println("--------");
        //public static double ceil(double a);返回大于或等于参数的最小double值，等于一个整数
        System.out.println(Math.ceil(13.00));
        System.out.println(Math.ceil(12.01));

        System.out.println("--------");
        //public static double floor(double a);返回小于或等于参数的最大double值，等于一个整数
        System.out.println(Math.floor(12.00));
        System.out.println(Math.floor(12.46));

        System.out.println("--------");
        //public static int round(float a);按照四舍五入返回最接近参数的int
        System.out.println(Math.round(4.5F));
        System.out.println(Math.round(4.4F));

        System.out.println("--------");
        //public static int max(int a,int b);返回两个int中最大值
        System.out.println(Math.max(7, 9));

        System.out.println("--------");
        //public static int min(int a,int b);返回两个int中最小值
        System.out.println(Math.min(7, 9));

        System.out.println("--------");
        //public static double pow(double a,double b);返回a的b次冥
        System.out.println(Math.pow(2.0, 3.0));

        System.out.println("--------");
        //public static double random();返回值为double的正值,[0.0--1)
        System.out.println((int) (Math.random() * 100) + 1);
    }
}
