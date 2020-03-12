package com.demo2.study10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsDemo1 {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<>();
        Student s1 = new Student("leixuesong", 21);
        Student s2 = new Student("zengyumei", 20);
        Student s3 = new Student("xuemeizai", 19);
        Student s4 = new Student("alibaba", 21);

        array.add(s1);
        array.add(s2);
        array.add(s3);
        array.add(s4);

        Collections.sort(array, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int i = s1.getAge() - s2.getAge();
                int result = i == 0 ? s1.getName().compareTo(s2.getName()) : i;
                return result;
            }
        });
        for (Student s : array) {
            System.out.println(s.getName() + ", " + s.getAge());
        }
    }
}
