package com.demo2.study7;

public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
//        return 0;     重复，不存储
//        return 1;     升序
//        return -1;    降序
        int i = this.age - o.age;
        int i1 = i == 0 ? this.name.compareTo(o.name) : i;
        return i1;
    }
}
