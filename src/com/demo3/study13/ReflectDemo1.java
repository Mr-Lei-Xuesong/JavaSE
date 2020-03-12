package com.demo3.study13;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取Class对象
        Class<?> aClass = Class.forName("com.demo3.study13.Student");

        //获取Class对象的构造方法
        Constructor<?> con = aClass.getConstructor(String.class, int.class, String.class);

        //创建对象
        Object o = con.newInstance("雷雪松", 21, "大竹");
        System.out.println(o);

    }
}
