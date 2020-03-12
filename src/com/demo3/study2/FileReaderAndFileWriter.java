package com.demo3.study2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderAndFileWriter {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("E:/StudyTest/demo.txt");
        FileWriter fw = new FileWriter("E:/StudyTest/copyDemo.txt");

        char[] ch = new char[1024];
        int len;
        while ((len = fr.read(ch)) != -1) {
            fw.write(ch, 0, len);
        }

        fw.close();
        fr.close();
    }
}
