package com.demo3.study13;
/*
获取Class类对象
 */
public class ReflectClass {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Student> c1 = Student.class;
        System.out.println(c1);

        Class<Student> c2 = Student.class;
        System.out.println(c1==c2);
        System.out.println("--------");

        Student S=new Student();
        Class<? extends Student> c3 = S.getClass();
        System.out.println(c1==c3);
        System.out.println("--------");

        Class<?> c4 = Class.forName("com.demo3.study13.Student");
        System.out.println(c1==c4);

    }
}
