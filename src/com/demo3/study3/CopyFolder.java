package com.demo3.study3;

import java.io.*;

public class CopyFolder {
    public static void main(String[] args) throws IOException {
        //创建数据源目录对象
        File srcFolder = new File("E:/StudyTest/Test");
        //创建目的地目录File对象
        File destFolder = new File("E:/StudyTest/CopyTest");
        //判断文件是否存在，不存在就创建
        if (!destFolder.exists()) {
            destFolder.mkdir();
        }
        //获取数据源目录下的文件
        File[] listFiles = srcFolder.listFiles();
        //遍历获取数据源下的文件
        for (File srcFile : listFiles) {
            //得到数据源下文件的名称
            String srcFileName = srcFile.getName();
            //创建目的的目录下的名称，与数据源目录下文件名称一致
            File destFile = new File(destFolder, srcFileName);
            //复制文件
            copyFile(srcFile, destFile);
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
