package com.demo2.study11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerDemo2 {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
        ArrayList<Integer> array = new ArrayList<>();

        String[] colors = {"♦", "♥", "♠", "♣"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        int index = 0;
        for (String number : numbers) {
            for (String color : colors) {
                hm.put(index, color + number);
                array.add(index);
                index++;
            }
        }
        /*for (String color:colors){
            for (String number:numbers){
                hm.put(index,color+number);
                array.add(index);
                index++;
            }
        }*/
        hm.put(index, "小王");
        array.add(index);
        index++;
        hm.put(index, "大王");
        array.add(index);

        Collections.shuffle(array);

        TreeSet<Integer> lei = new TreeSet<>();
        TreeSet<Integer> xue = new TreeSet<>();
        TreeSet<Integer> song = new TreeSet<>();
        TreeSet<Integer> dipai = new TreeSet<>();

        for (int i = 0; i < array.size(); i++) {
            int x = array.get(i);
            if (i >= array.size() - 3) {
                dipai.add(x);
            } else if (i % 3 == 0) {
                lei.add(x);
            } else if (i % 3 == 1) {
                xue.add(x);
            } else if (i % 3 == 2) {
                song.add(x);
            }
        }
        lookPoker("雷雪松", lei, hm);
        lookPoker("曾玉梅", xue, hm);
        lookPoker("雷浩", song, hm);
        lookPoker("底牌", dipai, hm);
    }

    public static void lookPoker(String name, TreeSet<Integer> ts, HashMap<Integer, String> hm) {
        System.out.print(name + "的牌是:");
        for (Integer i : ts) {
            String poker = hm.get(i);
            System.out.print(poker + ", ");
        }
        System.out.println();
    }
}
