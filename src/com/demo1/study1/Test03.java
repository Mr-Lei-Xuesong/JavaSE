package com.demo1.study1;

import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        int[] arr = {19, 28, 37, 46, 50};
        System.out.println("请输入要查找的数据:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
      /*  int index=-1;
        for (int x=0;x<arr.length;x++){
            if (arr[x]==number){
                index=x;
                break;
            }
        }*/
        int index = compareArr(arr, number);
        System.out.println("索引位置是:" + index);
    }

    public static int compareArr(int[] arr, int number) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                index = i;
                break;
            }
        }
        return index;
    }
}
