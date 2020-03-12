package com.demo2.study9;

public class FanXingJieKouDemo {
    public static void main(String[] args) {
        FanXingJieKou<String> f1=new FanXingJieKouImpl<>();
        f1.show("雷雪松");

        System.out.println("--------");
        FanXingJieKou<Integer> f2=new FanXingJieKouImpl<>();
        f2.show(21);

        System.out.println("--------");
        FanXingJieKou<Boolean> f3=new FanXingJieKouImpl<>();
        f3.show(true);
    }
}
