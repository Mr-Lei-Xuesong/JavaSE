package com.demo3.study11;

import java.util.function.Function;
/*
    String s="林青霞,30";
        1.将字符串截取到年龄部分
        2.将上一步的年龄字符串转换为int类型的数据
        3.将上一步的int数据加70，得到一个int结果，输出

 */
public class FunctionTest {
    public static void main(String[] args) {
        String s = "林青霞,30";

        /*convert(s,(String ss)->{
            return ss.split(",")[1];
        },(String ss)->{
            return Integer.parseInt(ss);
        },(Integer i)->{
            return i+70;
        });*/

        convert(s, ss -> ss.split(",")[1],Integer::parseInt, i -> i + 70);

    }

    private static void convert(String s, Function<String, String> fun1, Function<String, Integer> fun2, Function<Integer, Integer> fun3) {
        Integer i = fun1.andThen(fun2).andThen(fun3).apply(s);
        System.out.println(i);
    }
}
