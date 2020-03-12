package com.demo2.study1;

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr = {24, 25, 27, 26, 23};

        System.out.println("排序前:" + Arrays.toString(arr));

        Arrays.sort(arr);

        System.out.println("排序后:" + Arrays.toString(arr));
    }
}
