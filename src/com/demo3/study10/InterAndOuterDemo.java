package com.demo3.study10;

public class InterAndOuterDemo {
    public static void main(String[] args) {
        Outer o=new InterAndOuterImpl();
        o.test2();
        o.show2();
        Outer.look2();
        Inter i=new InterAndOuterImpl();
        i.test1();
        i.show1();
        Inter.look1();
    }
}
