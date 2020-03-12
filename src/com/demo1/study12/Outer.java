package com.demo1.study12;

public class Outer {
    private int age = 30;

    public void method() {
        int num = 20;
        class Inner {
            public void show() {
                System.out.println(age);
                System.out.println(num);
            }
        }
        Inner i = new Inner();
        i.show();
    }
}
