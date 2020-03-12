package com.demo3.study13;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //获取Class对象
        Class<?> aClass = Class.forName("com.demo3.study13.Student");

        //获取Class对象的构造方法
        Constructor<?> con = aClass.getConstructor();

        //创建对象
        Object o = con.newInstance();

        //获取成员变量
        Field name = aClass.getDeclaredField("name");
        Field age = aClass.getDeclaredField("age");
        Field address = aClass.getDeclaredField("address");

        //暴力反射
        name.setAccessible(true);
        age.setAccessible(true);
        address.setAccessible(true);
        //赋值成员变量
        name.set(o,"雷雪松");
        age.set(o,30);
        address.set(o,"大竹");
        System.out.println(o);
    }
}
