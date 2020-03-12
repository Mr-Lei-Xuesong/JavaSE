package com.demo3.study2;

import java.io.*;

public class BufferedDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:/StudyTest/PokerDemo2.java"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:/StudyTest/copyPoker.java"));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
