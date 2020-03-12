package com.demo3.study3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TxtToArrayList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:/Demo/test1.txt"));

        ArrayList<String> array = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            array.add(line);
        }
        br.close();

        for (String s : array) {
            System.out.println(s);
        }
    }
}
