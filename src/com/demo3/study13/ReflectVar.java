package com.demo3.study13;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/*
获取成员变量
 */
public class ReflectVar {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> aClass = Class.forName("com.demo3.study13.Student");

        //Field[] getFields​() 返回一个包含 Field对象的数组， Field对象反映由该 Class对象表示的类或接口的所有可访问的公共字段。
        //Field[] getDeclaredFields​() 返回一个 Field对象的数组，反映了由该 Class对象表示的类或接口声明的所有字段
        Field[] fields = aClass.getFields();
        for (Field s:fields){
            System.out.println(s);
        }

        System.out.println("--------");
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field s:declaredFields){
            System.out.println(s);
        }

        System.out.println("--------");
        //Field getDeclaredField​(String name) 返回一个 Field对象，该对象反映由该 Class对象表示的类或接口的指定声明字段。
        //Field getField​(String name) 返回一个 Field对象，该对象反映由该 Class对象表示的类或接口的指定公共成员字段。

        Field address = aClass.getField("address");

        //获取无参构造方法创建对象
        Constructor<?> c = aClass.getConstructor();
        Object o = c.newInstance();

        //void set​(Object obj, Object value) 将指定的对象参数中由此 Field对象表示的字段设置为指定的新值。
        address.set(o,"西安");
        System.out.println(o);
    }
}
