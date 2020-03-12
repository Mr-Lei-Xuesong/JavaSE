package com.demo3.study13;
/*
获取类的构造方法
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("all")
public class ReflectConstructor {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("com.demo3.study13.Student");

        //Constructor<?>[] getConstructors​() 返回一个包含 Constructor对象的数组， Constructor对象反映了由该 Class对象表示的类的所有公共构造函数。
        Constructor<?>[] cons = c.getConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }

        System.out.println("--------");
        //Constructor<?>[] getDeclaredConstructors​() 返回反映由该 Class对象表示的类声明的所有构造函数的 Constructor对象的数组。 
        Constructor<?>[] con1 = c.getDeclaredConstructors();
        for (Constructor con : con1) {
            System.out.println(con);
        }

        System.out.println("--------");
        //Constructor<T> getConstructor​(Class<?>... parameterTypes) 返回一个 Constructor对象，该对象反映由该 Class对象表示的类的指定公共构造函数。
        //Constructor<T> getDeclaredConstructor​(Class<?>... parameterTypes) 返回一个 Constructor对象，该对象反映由此 Class对象表示的类或接口的指定构造函数。
        //参数:你要获取的构造方法的参数个数和数据类型对应的字节码文件
        Constructor<?> cc = c.getConstructor();

        Object o = cc.newInstance();
        System.out.println(o);

    }
}
