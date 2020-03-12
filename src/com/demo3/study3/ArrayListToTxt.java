package com.demo3.study3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayListToTxt {
    public static void main(String[] args) throws IOException {
        ArrayList<String> array = new ArrayList<>();
        array.add("hello");
        array.add("world");
        array.add("java");

        BufferedWriter bf = new BufferedWriter(new FileWriter("E:/Demo/test1.txt"));

        for (String s : array) {
            bf.write(s);
            bf.newLine();
            bf.flush();
        }

        bf.close();
    }
}
