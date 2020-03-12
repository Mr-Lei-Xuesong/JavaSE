package com.demo1.study13;

public class JumppingDemo {
    public static void main(String[] args) {
        JumppingOperator jo = new JumppingOperator();
        Jumpping j = new Dog();

        jo.method(new Jumpping() {
            @Override
            public void jump() {
                System.out.println("猪可以跳高了");
            }
        });
        System.out.println("--------");

        jo.method(new Cat());

        System.out.println("--------");

        jo.method(j);
    }
}
