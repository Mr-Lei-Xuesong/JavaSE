package com.demo3.study12;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("雷雪松");
        list.add("曾玉梅");
        list.add("张三丰");
        list.add("林青霞");
        list.add("张曼玉");
        list.add("张无忌");


        //把list集合中姓张开头的元素输出
        list.stream().filter(s -> s.startsWith("张")).forEach(System.out::println);
        System.out.println("--------");
        //把list集合中长度为3的元素输出
        list.stream().filter(a -> a.length() == 3).forEach(System.out::println);
        System.out.println("--------");
        //把list集合元素中姓张，长度为3的元素输出
        list.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).forEach(System.out::println);
    }
}
