package com.demo3.study1;

import java.io.File;

public class DiGuiFile {
    public static void main(String[] args) {
        File srcFile = new File("E:/SpringMVC");

        getAllFilePath(srcFile);

    }

    public static void getAllFilePath(File srcFile) {
        File[] listFiles = srcFile.listFiles();//返回此抽象路径名表示的目录中的文件和目录的File对象数组
        if (listFiles != null) {//判断是否为空
            for (File file : listFiles) {//遍历
                if (file.isDirectory()) {//判断是否为文件
                    getAllFilePath(file);//如果是文件就递归继续调方法
                } else {
                    System.out.println(file.getAbsoluteFile());//返回此抽象路径名的绝对路径名字符串
                }
            }
        }
    }
}
