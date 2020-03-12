package com.demo1.study3;

public class StudyDemo4 {
    public static void main(String[] args) {
//        strTest1();
//        strTest2();
        int[] arr = {1, 2, 3};
        String s = reverse(arr);
        System.out.println(s);
    }

    public static String reverse(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i] + ", ");
            }
        }
        sb.append("]");
        String s = sb.toString();
        return s;
    }

    public static void strTest1() {
        StringBuilder sb = new StringBuilder("Hello World");
        System.out.println(sb);

        StringBuilder sb1 = new StringBuilder();
      /*  sb1.append("hello");
        sb1.append(200);
        sb1.append("java");*/
        sb1.append("java, ").append("hello ").append("world ").append(1);
        System.out.println(sb1);
        sb1.reverse();
        System.out.println(sb1);
    }

    public static void strTest2() {
        StringBuilder sb = new StringBuilder();
        sb.append("java");
        System.out.println("sb: " + sb);
//        String s=sb;
        String s = sb.toString();
        System.out.println("s: " + s);

        String s1 = "hello";
        System.out.println("s1: " + s1);
        StringBuilder sb1 = new StringBuilder(s1);
        System.out.println("sb1: " + sb1);
    }
}
