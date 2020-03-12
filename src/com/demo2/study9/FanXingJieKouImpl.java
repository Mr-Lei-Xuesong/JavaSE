package com.demo2.study9;

public class FanXingJieKouImpl<T> implements FanXingJieKou<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
