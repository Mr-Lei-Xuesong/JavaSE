package com.demo2.study10;

import java.util.*;
import java.util.HashMap;

public class ArrayListHashMap {
    public static void main(String[] args) {
        ArrayList<HashMap<String, String>> array = new ArrayList<>();
        HashMap<String, String> hm1 = new HashMap<>();
        hm1.put("雷雪松", "曾玉梅");
        hm1.put("郭靖", "黄蓉");

        HashMap<String, String> hm2 = new HashMap<>();
        hm2.put("杨过", "小龙女");
        hm2.put("孙策", "大乔");

        HashMap<String, String> hm3 = new HashMap<>();
        hm3.put("周瑜", "小乔");
        hm3.put("唐僧", "白龙马");

        array.add(hm1);
        array.add(hm2);
        array.add(hm3);

        for (HashMap<String, String> me : array) {
            Set<Map.Entry<String, String>> entries = me.entrySet();
            for (Map.Entry<String, String> he : entries) {
                String key = he.getKey();
                String value = he.getValue();
                System.out.println(key + "," + value);
            }
        }

    }
}
