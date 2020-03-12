package com.demo2.study11;

import java.util.ArrayList;
import java.util.Collections;

public class PoKerDemo1 {
    public static void main(String[] args) {
        //创建牌盒子
        ArrayList<String> array = new ArrayList<>();

        //往盒子里装牌
        String[] colors = {"♦", "♥", "♠", "♣"};//定义花色
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};//定义数量
        /*for (String color:colors){
            for (String number:numbers){
                array.add(color+number);
            }
        }*/
        for (String number : numbers) {
            for (String color : colors) {
                array.add(color + number);
            }
        }
        array.add("大王");
        array.add("小王");

        //洗牌
        Collections.shuffle(array);

        //发牌，创建三个集合来获取盒子里面的牌，剩余三张底牌
        ArrayList<String> lei = new ArrayList<>();
        ArrayList<String> xue = new ArrayList<>();
        ArrayList<String> song = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            String poker = array.get(i);
            if (i >= array.size() - 3) {
                dipai.add(poker);
            } else if (i % 3 == 0) {
                lei.add(poker);
            } else if (i % 3 == 1) {
                xue.add(poker);
            } else if (i % 3 == 2) {
                song.add(poker);
            }
        }
        lookPoker("雷雪松", lei);
        lookPoker("曾玉梅", xue);
        lookPoker("雷洪娅", song);
        lookPoker("底牌", dipai);
    }

    public static void lookPoker(String name, ArrayList<String> array) {
        System.out.print(name + "的牌是:");
        for (String poker : array) {
            System.out.print(poker + " ");
        }
        System.out.println();
    }
}
