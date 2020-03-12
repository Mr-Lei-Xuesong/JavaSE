package com.demo3.study12;

import java.util.ArrayList;

public class StreamDemo1 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();

        list.add("林青霞");
        list.add("张曼玉");
        list.add("张三丰");
        list.add("王祖贤");
        list.add("雷雪松");
        list.add("张敏");

        ArrayList<String> zhangList=new ArrayList<>();

        for (String s:list){
            if (s.startsWith("张")){
                zhangList.add(s);
            }
        }

        ArrayList<String> threeList=new ArrayList<>();

        for (String s:zhangList){
            if (s.length()==3){
                threeList.add(s);
            }
        }

        for (String s:threeList){
            System.out.println(s);
        }

        System.out.println("---------");
        list.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).forEach(System.out::println);
    }
}
