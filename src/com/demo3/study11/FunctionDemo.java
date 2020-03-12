package com.demo3.study11;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        convert("100",s->Integer.parseInt(s));

        System.out.println("--------");
        convert(10,i->String.valueOf(i+600));

        System.out.println("--------");
        convert("520",s->Integer.parseInt(s),i->String.valueOf(i+200));
    }
    //定义一个方法，把字符串类型转换为int类型
    private static void convert(String s, Function<String,Integer> fun){
        Integer i = fun.apply(s);
        System.out.println(i);
    }

    //定义一个方法，把一个int类型的数据加上一个整数后，转为字符串输出
    private static void convert(Integer i,Function<Integer,String> fun){
        String s = fun.apply(i);
        System.out.println(s);
    }

    //定义一个方法，把一个字符串转换为int类型，把int类型的数据加上一个整数后，转为字符串输出
    private static void convert(String s,Function<String,Integer> fun1,Function<Integer,String> fun2){
        /*Integer i = fun1.apply(s);
        String ss = fun2.apply(i);
        System.out.println(ss);*/
        String s1 = fun1.andThen(fun2).apply(s);
        System.out.println(s1);
    }

}
