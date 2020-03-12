package com.demo3.study1;

import java.io.File;

public class FileDemo3 {
    public static void main(String[] args) {
        File f = new File("E:/StudyTest");
        //测试此抽象路径名表示的File是否为目录
        System.out.println(f.isDirectory());

        System.out.println("--------");
        //测试此抽象路径名表示的File是否为文件
        System.out.println(f.isFile());

        System.out.println("--------");
        //测试此抽象路径名表示的File是否存在
        System.out.println(f.exists());

        System.out.println("--------");
        //返回此抽象路径名的绝对路径名字符串
        System.out.println(f.getAbsoluteFile());

        System.out.println("--------");
        //将此抽象路径名转换为路径名字符串
        System.out.println(f.getPath());

        System.out.println("--------");
        //返回由此抽象路径名表示的文件或目录名称
        System.out.println(f.getName());

        System.out.println("--------");
        //返回此抽象路径名表示的目录中的文件和目录的名称字符串数组
        String[] lists = f.list();
        for (String list : lists) {
            System.out.println(list);
        }

        System.out.println("--------");
        //返回此抽象路径名表示的目录中的文件和目录的File对象数组
        File[] listFiles = f.listFiles();
        for (File list : listFiles) {
            if (list.isFile()) {
                System.out.println(list);
            }
        }
    }
}
