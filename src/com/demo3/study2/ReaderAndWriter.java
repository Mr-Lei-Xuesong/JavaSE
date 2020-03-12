package com.demo3.study2;

import java.io.*;

public class ReaderAndWriter {
    public static void main(String[] args) throws IOException {
        /*OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("E:/StudyTest/demo.txt"));
        osw.write("中国");
        osw.close();
*/
        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:/StudyTest/demo.txt"));
        int ch;
        while ((ch = isr.read()) != -1) {
            System.out.print((char) ch);
        }
    }
}
    