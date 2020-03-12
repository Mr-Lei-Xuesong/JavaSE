package com.demo2.study9;

public class FanXingDemo {
    public static void main(String[] args) {
        FanXingLei<String> f1 = new FanXingLei<>();
        f1.setT("这是字符串");
        System.out.println(f1.getT());

        System.out.println("--------");
        FanXingLei<Integer> f2 = new FanXingLei<>();
        f2.setT(111);
        System.out.println(f2.getT());

        System.out.println("--------");
        FanXingLei<Boolean> f3 = new FanXingLei<>();
        f3.setT(false);
        System.out.println(f3.getT());

    }
}
