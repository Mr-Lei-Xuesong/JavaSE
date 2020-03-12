package com.demo3.study9;

public class AddableDemo {
    public static void main(String[] args) {
        useAddable((int x,int y)->{
            return x+y;
        });
    }
    public static void useAddable(Addable a){
        int sum = a.add(10, 20);
        System.out.println(sum);
    }
}
