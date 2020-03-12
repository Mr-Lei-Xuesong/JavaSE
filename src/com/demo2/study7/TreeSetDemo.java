package com.demo2.study7;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<>();

        Student s1 = new Student("aaa", 10);
        Student s2 = new Student("bbb", 20);
        Student s3 = new Student("ccc", 30);
        Student s4 = new Student("ddd", 16);
        Student s5 = new Student("eee", 20);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);

        for (Student s : ts) {
            System.out.println(s.getName() + ", " + s.getAge());
        }
    }
}
