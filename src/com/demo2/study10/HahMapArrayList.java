package com.demo2.study10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HahMapArrayList {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        ArrayList<String> array1 = new ArrayList<>();
        array1.add("雷雪松");
        array1.add("测试1");
        ArrayList<String> array2 = new ArrayList<>();
        array2.add("曾玉梅");
        array2.add("测试2");
        ArrayList<String> array3 = new ArrayList<>();
        array3.add("雪妹仔");
        array3.add("测试3");

        hm.put("ceshi001", array1);
        hm.put("ceshi002", array2);
        hm.put("ceshi003", array3);

        Set<Map.Entry<String, ArrayList<String>>> entries = hm.entrySet();
        for (Map.Entry<String, ArrayList<String>> map : entries) {
            String key = map.getKey();
            ArrayList<String> value = map.getValue();
            System.out.println(key + ", " + value);
        }
    }
}
