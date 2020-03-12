package com.demo3.study13;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //创建Class对象
        Class<?> aClass = Class.forName("com.demo3.study13.Student");

        //创建Class对象的构造方法
        Constructor<?> c = aClass.getConstructor();
        //创建对象
        Object o = c.newInstance();

        Method method1 = aClass.getMethod("method1");
        method1.invoke(o);

        Method method2 = aClass.getMethod("method2", String.class);
        method2.invoke(o,"雷雪松");

        Method method3 = aClass.getMethod("method3", String.class, int.class);
        Object o1 = method3.invoke(o, "林青霞", 30);
        System.out.println(o1);

        Method function = aClass.getDeclaredMethod("function");
        function.setAccessible(true);
        function.invoke(o);

    }
}
