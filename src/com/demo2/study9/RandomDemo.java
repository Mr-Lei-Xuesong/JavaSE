package com.demo2.study9;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/*
创建10个1-20之间的随机数，要求随机数不能重复
 */
public class RandomDemo {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        Random s = new Random();

        while (set.size() < 10) {
            int i = s.nextInt(20) + 1;
            set.add(i);
        }

        for (Integer i1 : set) {
            System.out.println(i1);
        }

        System.out.println("--------");
        Set<Integer> set1 = new HashSet<>();

        while (set1.size() < 10) {
            int i = s.nextInt(20) + 1;
            set1.add(i);
        }

        for (Integer i1 : set1) {
            System.out.println(i1);
        }
    }
}
