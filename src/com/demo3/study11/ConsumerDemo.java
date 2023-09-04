package com.demo3.study11;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        operatorString("雷雪松", System.out::println);
        operatorString("雷雪松",s-> System.out.println(new StringBuilder(s).reverse().toString()));

        System.out.println("--------");
        operatorString(System.out::println, s-> System.out.println(new StringBuilder(s).reverse().toString()));
    }

    private static void operatorString (String name, Consumer<String> con){
        con.accept(name);
    }

    private static void operatorString(Consumer<String> con1, Consumer<String> con2){
        /*con1.accept(name);
        con2.accept(name);*/
        con1.andThen(con2).accept("测试");
    }
}
