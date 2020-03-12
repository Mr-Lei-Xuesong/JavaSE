package com.demo1.study6;

public class TestDemo {
    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.setName("雷雪松");
        t1.setAge(22);
        System.out.println(t1.getName() + ", " + t1.getAge());
        t1.teach();

        System.out.println("----------------");
        Teacher t2 = new Teacher("曾玉梅", 19);
        System.out.println(t2.getName() + ", " + t2.getAge());
        t2.teach();

        System.out.println("----------------");
        Student s1 = new Student();
        s1.setName("小雷");
        s1.setAge(18);
        System.out.println(s1.getName() + ", " + s1.getAge());
        s1.study();

        System.out.println("----------------");
        Student s2 = new Student("小曾", 18);
        System.out.println(s2.getName() + ", " + s2.getAge());
        s2.study();
    }
}
