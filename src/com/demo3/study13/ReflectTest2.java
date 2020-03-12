package com.demo3.study13;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
    通过配置文件运行类中的方法
 */
public class ReflectTest2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Properties pro = new Properties();
        FileReader fr = new FileReader("E:/StudyTest/class.txt");
        pro.load(fr);
        fr.close();

        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        Class<?> c = Class.forName(className);

        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();

        Method method = c.getMethod(methodName);

        method.invoke(obj);
    }
}
