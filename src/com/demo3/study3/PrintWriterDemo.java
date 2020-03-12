package com.demo3.study3;

import java.io.*;

public class PrintWriterDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("E:/StudyTest/PokerDemo2.java"));
        PrintWriter pw = new PrintWriter(new FileWriter("E:/StudyTest/CopyPokerDemo2.java"), true);

        String line;
        while ((line = bf.readLine()) != null) {
            pw.println(line);
        }
        bf.close();
        pw.close();
    }
}
