package com.demo2.study9;

public class KeBianCanShu {
    public static void main(String[] args) {
        System.out.println(sum(1,2));
        System.out.println(sum(1,2,3));
        System.out.println(sum(1,2,3,4));
        System.out.println(sum(1,2,3,4,5));
        System.out.println(sum(1,2,3,4,5,6));
        System.out.println(sum(1,2,3,4,5,6,7));
        System.out.println(sum(1,2,3,4,5,6,7,8));
    }
    public static int sum(int... a){
        int sum=0;
        for (int i:a){
            sum+=i;
        }
        return sum;
    }
}
