package com.demo2.study5;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo1 {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();
        //添加
        c.add("hello");
        c.add("world");
        c.add("java");
        System.out.println(c);
        System.out.println("--------");
        //移除
        c.remove("hello");
        System.out.println(c);
        System.out.println("--------");
        //判断是否有指定元素
        System.out.println(c.contains("java"));
        //长度
        System.out.println(c.size());
        //清除
        c.clear();
        System.out.println(c);
        System.out.println("--------");
        //是否为空
        System.out.println(c.isEmpty());

    }
}
