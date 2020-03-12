package com.demo2.study5;

import java.util.LinkedList;

public class LinkedLisetDemo {
    public static void main(String[] args) {
        LinkedList<String> lkd=new LinkedList<>();
        lkd.add("hello");
        lkd.add("world");
        lkd.add("java");
        System.out.println(lkd);

        System.out.println("--------");
        lkd.addFirst("first");
        System.out.println(lkd);

        System.out.println("--------");
        lkd.addLast("last");
        System.out.println(lkd);

        System.out.println("--------");
        System.out.println(lkd.getFirst());

        System.out.println("--------");
        System.out.println(lkd.getLast());

        System.out.println("--------");
        System.out.println(lkd.removeFirst());

        System.out.println("--------");
        System.out.println(lkd.removeLast());

        System.out.println("--------");
        System.out.println(lkd);
    }
}
