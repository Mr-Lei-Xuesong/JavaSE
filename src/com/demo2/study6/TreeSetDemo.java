package com.demo2.study6;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(11);
        treeSet.add(13);
        treeSet.add(12);
        treeSet.add(19);
        treeSet.add(16);

        for (Integer i : treeSet) {
            System.out.println(i);
        }
    }
}
