package com.demo3.study4;

import java.io.*;
import java.util.Properties;

public class PropertiesDemo2 {
    public static void main(String[] args) throws IOException {
//        myStore();
        myLoad();
    }

    private static void myLoad() throws IOException {
        Properties ppt = new Properties();
        BufferedReader br = new BufferedReader(new FileReader("E:/StudyTest/Properties.txt"));
        ppt.load(br);
        br.close();
        System.out.println(ppt);
    }

    private static void myStore() throws IOException {
        Properties ppt = new Properties();
        ppt.setProperty("ceshi001", "雷雪松");
        ppt.setProperty("ceshi002", "曾玉梅");
        ppt.setProperty("ceshi003", "张无忌");

        BufferedWriter bw = new BufferedWriter(new FileWriter("E:/StudyTest/Properties.txt"));
        ppt.store(bw, null);
        bw.close();
    }
}
