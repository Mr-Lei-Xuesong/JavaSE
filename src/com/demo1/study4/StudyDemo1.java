package com.demo1.study4;

import java.util.ArrayList;

public class StudyDemo1 {
    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        ArrayList<Integer> arrayList = new ArrayList();
//        arrayList.add("java");
        arrayList.add(100);
        arrayList.add(200);
        System.out.println(arrayList);

        ArrayList<String> array = new ArrayList();
        array.add("hello");
        array.add("world");
        array.add("java");

        array.add(0, "no1");
        array.add(4, "test");

        System.out.println(array);

        array.remove("no1");
        array.remove(0);
        array.set(0, "test");
        System.out.println(array.get(1));
        System.out.println(array.size());
        System.out.println(array);
    }

    public static void test2() {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("hello");
        arrayList.add("world");
        arrayList.add("java");
        for (int i = 0; i < arrayList.size(); i++) {
            String s = arrayList.get(i);
            System.out.println(s);
        }
    }
}
