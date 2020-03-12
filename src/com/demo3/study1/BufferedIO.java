package com.demo3.study1;

import java.io.*;

public class BufferedIO {
    public static void main(String[] args) throws IOException {
        /*BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("E:/StudyTest/study.txt"));

        bos.write("hello\r\n".getBytes());
        bos.write("world\r\n".getBytes());

        bos.close();*/

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:/StudyTest/study.txt"));

        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            System.out.println(new String(bys, 0, len));
        }
        bis.close();

    }
}
