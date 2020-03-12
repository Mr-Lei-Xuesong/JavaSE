package com.demo2.study2;

import java.util.Arrays;

public class StringDemo {
    public static void main(String[] args) {
        //定义一个字符串
        String s = "91 27 46 38 50";
        //把字符串中的数字数据存储到一个int类型的数组中
        String[] s1 = s.split(" ");

      /*  for (int i=0;i<s1.length;i++){
            System.out.println(s1[i]);
        }*/
        //定义一个int数组，把String[]中每一个元素都存储到int数组中
        int[] arr = new int[s1.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        /*for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }*/
        //对int数组进行排序
        Arrays.sort(arr);

        //把排序过后的int数组元素进行拼接得到一个字符串，采用StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(" ");
            }
        }
        String s2 = sb.toString();
        System.out.println("最终结果:" + s2);
    }
}
