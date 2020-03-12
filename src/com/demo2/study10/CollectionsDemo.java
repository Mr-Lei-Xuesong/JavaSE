package com.demo2.study10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(30);
        list.add(50);
        list.add(40);
        list.add(20);
        System.out.println(list);

        System.out.println("--------");
        Collections.sort(list);
        System.out.println(list);

        System.out.println("--------");
        Collections.reverse(list);
        System.out.println(list);

        System.out.println("--------");
        Collections.shuffle(list);
        System.out.println(list);
    }
}
