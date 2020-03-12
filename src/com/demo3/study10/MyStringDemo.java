package com.demo3.study10;

public class MyStringDemo {
    public static void main(String[] args) {
        /*useMyString((s,x,y)->{
            return s.substring(x, y);
        });*/

        useMyString((s,x,y)->s.substring(x,y));
        //第一个参数作为调用者，后面所有的参数都转递给该方法作为参数
        useMyString(String::substring);

    }

    public static void useMyString(MyString ms){
        String s = ms.mySubString("helloworld", 1, 6);
        System.out.println(s);
    }
}
