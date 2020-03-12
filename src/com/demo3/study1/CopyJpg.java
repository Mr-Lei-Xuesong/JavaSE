package com.demo3.study1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyJpg {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:/StudyTest/1.jpg");
        FileOutputStream fos = new FileOutputStream("E:/StudyTest/JavaWeb/copy.jpg");

        byte[] bys = new byte[1024];
        int len;
        while ((len = fis.read(bys)) != -1) {
            fos.write(bys, 0, len);
        }

        fos.close();
        fis.close();
    }
}
