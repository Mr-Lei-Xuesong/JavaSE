package com.demo3.study1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        //文件输出流
        FileOutputStream fos = new FileOutputStream("E:/StudyTest/java.txt");
//        //第一种方法
//        fos.write(97);
//        //第二种方法
//        byte[] bys={98,99,100,101,102};
//        fos.write(bys);
        //第三种方法
        byte[] bytes = "abcdef".getBytes();
        fos.write(bytes, 0, bytes.length);
        fos.close();
        //文件输入流
        FileInputStream fis = new FileInputStream("E:/StudyTest/java.txt");
        int rd;
        while ((rd = fis.read()) != -1) {
            System.out.print((char) rd);
        }
    }
}
