package com.test;

/**
 * 设一维数组V中存有n个整数，
 * （1）写一个算法，将数组中的非零元素移到前面来，零元素移到后面去，
 * 各非零元素间的相对位置不变；
 * （2）分析所写算法的时间复杂度
 */
public class AlgorithmDemo {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 0, 0, 3, 12, 33, 3, 5, 0, 14};
        printArr(array);
        System.out.println("--------");
        change(array);
        printArr(array);
    }

    public static void change(int[] array) {
        int index=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]!=0 && i!=index){
                if (i!=index){
                    int tmp=array[index];
                    array[index]=array[i];
                    array[i]=tmp;
                    index++;
                }else {
                    index++;
                }
            }
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
        System.out.println("]");
    }
}
