package com.demo3.study1;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:/StudyTest/java.txt");

        byte[] bys = new byte[1024];
        int len;
        while ((len = fis.read(bys)) != -1) {
//            System.out.println(len); //len代表的是实际读取的个数
            System.out.println(new String(bys, 0, len));
        }

        fis.close();
    }
}
