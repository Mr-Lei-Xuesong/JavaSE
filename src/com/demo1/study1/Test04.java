package com.demo1.study1;

public class Test04 {
    public static void main(String[] args) {
        int[] arr = {18, 36, 47, 64, 94};
        reverse(arr);
        printArr(arr);
    }

    public static void reverse(int[] arr) {
        for (int star = 0, end = arr.length - 1; star <= end; star++, end--) {
            int temp = arr[star];
            arr[star] = arr[end];
            arr[end] = temp;
        }
    }

    public static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.print("]");
    }
}
