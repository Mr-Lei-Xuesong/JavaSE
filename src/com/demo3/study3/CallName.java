package com.demo3.study3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class CallName {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:/Demo/name.txt"));
        ArrayList<String> array = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            array.add(line);
        }
        br.close();

        Random rd = new Random();
        int i = rd.nextInt(array.size());
        String s = array.get(i);
        System.out.println(s);

    }
}
