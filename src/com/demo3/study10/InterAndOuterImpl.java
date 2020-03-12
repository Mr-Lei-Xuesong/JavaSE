package com.demo3.study10;

public class InterAndOuterImpl implements Inter,Outer{

    @Override
    public void test1() {
        System.out.println("测试1被执行了");
    }

    @Override
    public void test2() {
        System.out.println("测试2被执行了");
    }
}
