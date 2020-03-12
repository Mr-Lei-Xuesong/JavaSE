package com.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {

    @Before
    public void init(){
        System.out.println("所有测试方法执行前，都会先执行该方法");
    }

    @After
    public void close(){
        System.out.println("所有测试方法执行后，都会执行该方法");
    }

    @Test
    public void test1(){
        Student s=new Student();
        s.study();
    }

    @Test
    public void testAdd(){
        Student s=new Student();
        int result = s.add(5, 9);

        //断言
        Assert.assertEquals(14,result);
        System.out.println(result);
    }
}
