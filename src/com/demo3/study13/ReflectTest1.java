package com.demo3.study13;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/*
    ArrayList<Integer>集合中添加一个字符串
 */
public class ReflectTest1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //创建集合
        ArrayList<Integer> array=new ArrayList<>();

        array.add(20);
        array.add(30);

        Class<? extends ArrayList> c = array.getClass();

        Method add = c.getDeclaredMethod("add", Object.class);
        add.invoke(array,"hello");
        add.invoke(array,"world");
        add.invoke(array,"java");

        System.out.println(array);
    }
}
