package com.util;

import sun.misc.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @Author: xuesong.lei
 * @Date: 2023/7/4 16:20
 * @Description:
 */
public class ReadZipFileDemo {
    public static void main(String[] args) throws Exception {
        List<String> list = readZipData("D:\\Temp\\DictEnterpriseRel_北京_095170f6ab7e49cc98643c5bd849ed93_20230530.zip");
        list.forEach(System.out::println);
    }


    private static InputStream getInputStream() throws Exception {
        File file = new File("D:\\Temp\\DictEnterpriseRel_北京_095170f6ab7e49cc98643c5bd849ed93_20230530.zip");
        return Files.newInputStream(file.toPath());
    }

    public static String readZip(String fileName) throws IOException {
        ZipFile zip = new ZipFile(fileName);
        File file = new File(fileName);
        String parentZipParent = file.getParent();// 获取上级文件夹解压到这里
        File temp = file;
        BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(Paths.get(fileName)));
        ZipInputStream zis = new ZipInputStream(bis);
        ZipEntry entry;//用于获取压缩文件中的文件或文件夹
        StringBuffer sb = new StringBuffer();
        while ((entry = zis.getNextEntry()) != null) {
            if (entry.isDirectory()) {
                //System.out.println("文件夹");
            } else {
                //System.out.println("file:"+entry.getName());
                if (entry.getName().endsWith("txt")) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(zip.getInputStream(entry)));
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        //System.out.println(line);
                        sb.append(line);
                    }
                } else if (entry.getName().endsWith("zip")) {  //判断是否为压缩包，若是则将其解压出再读取
                    temp = new File(parentZipParent + "\\" + entry.getName());
                    //System.out.println(temp.getAbsolutePath());
                    if (! temp.getParentFile().exists()) {
                        temp.getParentFile().mkdirs();
                    }
                    OutputStream os = Files.newOutputStream(temp.toPath());
                    // 通过ZipFile的getInputStream方法拿到具体的ZipEntry的输入流
                    InputStream is = zip.getInputStream(entry);
                    int len = 0;
                    while ((len = is.read()) != - 1) {
                        os.write(len);
                    }
                    sb.append(readZip(temp.getAbsolutePath()));
                }
            }
        }
        return sb.toString();
    }

    public static List<String> readZipData(String fileName) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(Paths.get(fileName)));
        ZipInputStream zis = new ZipInputStream(bis, java.nio.charset.Charset.forName("GBK"));
        ZipEntry entry;//用于获取压缩文件中的文件或文件夹
        StringBuilder sb = new StringBuilder();
        while ((entry = zis.getNextEntry()) != null) {
            if (entry.getName().endsWith("txt")) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(zis,"GBK"));
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            }
            list.add(sb.toString());
        }
        return list;
    }


}
