package com.demo3.study3;

import java.io.*;

public class CopyFolders {
    public static void main(String[] args) throws IOException {
        //创建数据源File对象
        File srcFile = new File("E:/StudyTest");
        //创建目的地File对象
        File destFile = new File("D:/");
        //创建方法实现文件复制，参数为数据源对象，目的地对象
        copyFolder(srcFile, destFile);
    }

    private static void copyFolder(File srcFile, File destFile) throws IOException {
        //判断数据源是否为目录
        if (srcFile.isDirectory()) {
            //在目的地下创建与数据源名称一样的目录
            String srcFileName = srcFile.getName();
            File newFolder = new File(destFile, srcFileName);//D:/StudyTest
            if (!newFolder.exists()) {
                newFolder.mkdir();
            }
            //获取数据源对象下所有文件或目录的数组
            File[] fileArray = srcFile.listFiles();
            for (File file : fileArray) {
                copyFolder(file, newFolder);
            }
        } else {
            File newFile = new File(destFile, srcFile.getName());
            copyFile(srcFile, newFile);
        }
    }

    private static void copyFile(File srcFile, File destFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }

        bos.close();
        bis.close();
    }
}
