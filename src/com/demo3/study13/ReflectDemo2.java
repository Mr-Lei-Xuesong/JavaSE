package com.demo3.study13;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo2 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取Class对象
        Class<Student> aClass = Student.class;

        //获取Class对象的构造方法
        Constructor<Student> ss = aClass.getDeclaredConstructor(String.class);

        //暴力反射
        ss.setAccessible(true);

        //创建对象
        Student student = ss.newInstance("雷雪松");
        System.out.println(student);
    }
}
