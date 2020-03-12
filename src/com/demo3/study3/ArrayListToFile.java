package com.demo3.study3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayListToFile {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> array = new ArrayList<>();
        Student s1 = new Student("ceshi001", "雷雪松", 22, "达州");
        Student s2 = new Student("ceshi002", "曾玉梅", 21, "遂宁");
        Student s3 = new Student("ceshi003", "向鹏", 21, "德阳");
        Student s4 = new Student("ceshi004", "苏红", 21, "成都");

        array.add(s1);
        array.add(s2);
        array.add(s3);
        array.add(s4);

        BufferedWriter bw = new BufferedWriter(new FileWriter("E:/Demo/student.txt"));

        for (Student s : array) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.getSid()).append(",").append(s.getName()).append(",").append(s.getAge()).append(",").append(s.getAddress());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }

        bw.close();
    }
}
