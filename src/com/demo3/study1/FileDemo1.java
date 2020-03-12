package com.demo3.study1;

import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) {
        File f1 = new File("E:/ceshi/lei.txt");
        System.out.println(f1);

        File f2 = new File("E:/ceshi", "lei.txt");
        System.out.println(f2);

        File f3 = new File("E:/ceshi");
        File f4 = new File(f3, "lei.txt");
        System.out.println(f4);
    }
}
