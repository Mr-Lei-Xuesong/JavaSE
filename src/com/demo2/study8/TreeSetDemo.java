package com.demo2.study8;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int i = o1.getAge() - o2.getAge();
                int i1 = i == 0 ? o1.getName().compareTo(o2.getName()) : i;
                return i1;
            }
        });
        Student s1 = new Student("aaa", 18);
        Student s2 = new Student("bbb", 19);
        Student s3 = new Student("ccc", 16);
        Student s4 = new Student("ddd", 17);
        Student s5 = new Student("eee", 18);

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
