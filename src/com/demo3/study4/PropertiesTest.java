package com.demo3.study4;

import java.io.*;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties ppt = new Properties();
        BufferedReader br = new BufferedReader(new FileReader("E:/StudyTest/game.txt"));

        ppt.load(br);
        br.close();

        String count = ppt.getProperty("count");
        int number = Integer.parseInt(count);

        if (number >= 3) {
            System.out.println("游戏试玩已结束，想玩请充值！！联系QQ:228389787");
        } else {
            GuessNumber.start();
            number++;
            ppt.setProperty("count", String.valueOf(number));
            BufferedWriter bw = new BufferedWriter(new FileWriter("E:/StudyTest/game.txt"));
            ppt.store(bw, null);
            bw.close();
        }
    }
}
