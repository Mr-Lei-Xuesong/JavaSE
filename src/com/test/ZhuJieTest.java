package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@ZhuJie(className = "com.demo1.study13.Dog",methodName = "jump")
public class ZhuJieTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        //获取Class对象字节码
        Class<ZhuJieTest> zhuJieTestClass = ZhuJieTest.class;
        //获取指定注解
        ZhuJie annotation = zhuJieTestClass.getAnnotation(ZhuJie.class);
        //调用注解中的抽象方法获取配置的属性值
        String s1 = annotation.className();
        String s2 = annotation.methodName();

        Class<?> aClass = Class.forName(s1);
        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();
        Method method = aClass.getMethod(s2);
        method.invoke(o);

    }
}
