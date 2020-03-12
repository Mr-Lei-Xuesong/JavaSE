package com.demo3.study1;

import java.io.File;
import java.io.IOException;

public class FileDemo2 {
    public static void main(String[] args) throws IOException {
        //创建文件夹
        File f1 = new File("E:/StudyTest");
        System.out.println(f1.mkdir());
        System.out.println("--------");

        //创建文件
        File f2 = new File("E:/StudyTest/java.txt");
        System.out.println(f2.createNewFile());
        System.out.println("--------");

        //创建目录
        File f3 = new File("E:/StudyTest/JavaSE");
        System.out.println(f3.mkdir());
        System.out.println("--------");

        //创建多级目录
        File f4 = new File("E:/StudyTest/JavaWeb/HTML");
        System.out.println(f4.mkdirs());
    }
}
