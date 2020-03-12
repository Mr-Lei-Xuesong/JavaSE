package com.demo2.study1;

public class ObjectDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("雷雪松");
        s1.setAge(22);

        Student s2 = new Student();
        s2.setName("雷雪松");
        s2.setAge(22);

        System.out.println(s1.equals(s2));
    }
}
