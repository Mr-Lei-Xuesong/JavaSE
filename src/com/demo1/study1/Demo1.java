package com.demo1.study1;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个数:");
        int i = sc.nextInt();
        /*int sum=0;
        for (int j=0;j<=i;j++){
            sum+=j;
        }*/
        int sum=i*(i+1)/2;
        System.out.println(sum);
    }
}
