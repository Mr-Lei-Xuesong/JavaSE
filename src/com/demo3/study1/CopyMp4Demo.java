package com.demo3.study1;

import java.io.*;

/*
    思路：
        1.根据数据源创建字节输入流对象
        2.根据目的地创建字节输出流对象
        3.读写数据，复制视频
        4.释放资源
    四种方式：
        1.基本字节流一次读写一个字节
        2.基本字节流一次读写一个字节数组
        3.字节缓冲流一次读写一个字节
        4.字节缓冲流一次读写一个字节数组
 */
public class CopyMp4Demo {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
//        method1();//34755毫秒
//        method2();//177毫秒
//        method3();//116毫秒
        method4();//21毫秒
        long endTime = System.currentTimeMillis();
        System.out.println("共耗时:" + (endTime - startTime) + "毫秒");
    }

    //基本字节流一次读写一个字节
    public static void method1() throws IOException {
        FileInputStream fis = new FileInputStream("E:/StudyTest/bg.mp4");
        FileOutputStream fos = new FileOutputStream("E:/StudyTest/copy1.mp4");

        int len;
        while ((len = fis.read()) != -1) {
            fos.write(len);
        }
        fos.close();
        fis.close();
    }

    //基本字节流一次读写一个字节数组
    public static void method2() throws IOException {
        FileInputStream fis = new FileInputStream("E:/StudyTest/bg.mp4");
        FileOutputStream fos = new FileOutputStream("E:/StudyTest/copy2.mp4");

        byte[] bys = new byte[1024];
        int len;
        while ((len = fis.read(bys)) != -1) {
            fos.write(bys, 0, len);
        }
        fos.close();
        fis.close();
    }

    //字节缓冲流一次读写一个字节
    public static void method3() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:/StudyTest/bg.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:/StudyTest/copy3.mp4"));

        int len;
        while ((len = bis.read()) != -1) {
            bos.write(len);
        }
        bos.close();
        bis.close();
    }

    //字节缓冲流一次读写一个字节数组
    public static void method4() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:/StudyTest/bg.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:/StudyTest/copy4.mp4"));

        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }
        bis.close();
        bos.close();
    }
}
