package com.demo2.study6;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Student> hs = new HashSet<>();
        Student s1 = new Student("雷雪松", 18);
        Student s2 = new Student("测试", 17);
        Student s3 = new Student("雷雪松", 18);

        hs.add(s1);
        hs.add(s2);
        hs.add(s3);

        for (Student s : hs) {
            System.out.println(s.getName() + ", " + s.getAge());
        }
    }
}
