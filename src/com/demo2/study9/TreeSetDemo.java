package com.demo2.study9;
/*
总分从高到低
 */

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<>();

        Student s1 = new Student("林青霞", 93, 89);
        Student s2 = new Student("张曼玉", 88, 94);
        Student s3 = new Student("刘德华", 96, 92);
        Student s4 = new Student("薛之谦", 89, 93);
        Student s5 = new Student("许嵩", 86, 76);
        Student s6 = new Student("张国荣", 89, 93);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);

        for (Student s : ts) {
            System.out.println("名字:" + s.getName() + ", 语文:" + s.getChinese() + ",数学: " + s.getMath() + ", 总分:" + s.getSum());
        }
    }
}
