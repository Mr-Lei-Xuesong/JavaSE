package com.demo1.study4;

import java.util.ArrayList;

public class StudyDemo2 {
    public static void main(String[] args) {
        ArrayList<Student> arrayList = new ArrayList<>();

        Student s1 = new Student("测试1", "18");
        Student s2 = new Student("测试2", "19");
        Student s3 = new Student("测试3", "20");

        arrayList.add(s1);
        arrayList.add(s2);
        arrayList.add(s3);

        for (int i = 0; i < arrayList.size(); i++) {
            Student student = arrayList.get(i);
            System.out.println(student.getName() + ", " + student.getAge());
        }
    }
}
