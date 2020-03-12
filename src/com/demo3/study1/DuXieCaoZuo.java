package com.demo3.study1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DuXieCaoZuo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:/StudyTest/java.txt");
        FileOutputStream fos = new FileOutputStream("E:/StudyTest/test.txt");

        int rd;
        while ((rd = fis.read()) != -1) {
            fos.write(rd);
        }

        fos.close();
        fis.close();
    }
}
