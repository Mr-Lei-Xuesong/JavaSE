package com.demo1.study2;

public class DemoStudy06 {
    public static void main(String[] args) {
        //基本数据类型的参数，形参改变不影响实参
        int number = 100;
        System.out.println(number);
        change1(number);
        System.out.println(number);

        //引用数据类型的参数，形参改变影响实参
        System.out.println("======分割线=======");
        int[] arr = {10, 20, 30};
        System.out.println(arr[1]);
        change2(arr);
        System.out.println(arr[1]);
    }

    public static void change1(int number) {
        number = 200;
    }

    public static void change2(int[] arr) {
        arr[1] = 200;
    }
}
