package com.demo2.study5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");

        ListIterator<String> it = list.listIterator();
        //正向迭代
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("--------");
        //反向迭代
        while (it.hasPrevious()) {
            String s1 = it.previous();
            System.out.println(s1);
        }
        //测试
        /*Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if (next.equals("world")){
                list.add("javase");
            }
        //报错：ConcurrentModificationException  并发修改异常
        }*/
        //如果元素中有world就添加一个元素javase
        System.out.println("--------");
        while (it.hasNext()) {
            String next = it.next();
            if (next.equals("world")) {
                it.add("javase");
            }
        }
        System.out.println(list);

        System.out.println("--------");
        //如果元素中有world就添加一个元素javaee
        Iterator<String> iterator = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.equals("world")) {
                list.add("javaee");
            }
        }
        System.out.println(list);
    }
}
