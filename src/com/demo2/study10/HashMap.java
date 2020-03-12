package com.demo2.study10;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class HashMap {
    public static void main(String[] args) {
        Map<String, String> map = new java.util.HashMap<>();
        map.put("ceshi001", "雷雪松");
        map.put("ceshi002", "曾玉梅");
        map.put("ceshi003", "雷小松");
        System.out.println(map);

        System.out.println("--------");
        System.out.println(map.remove("ceshi001"));
        System.out.println(map);

        System.out.println("--------");
        System.out.println(map.containsKey("ceshi001"));

        System.out.println("--------");
        System.out.println(map.containsValue("雷雪松"));

        System.out.println("--------");
        System.out.println(map.isEmpty());

        System.out.println("--------");
        System.out.println(map.size());

        System.out.println("--------");
        String ceshi002 = map.get("ceshi002");
        System.out.println(ceshi002);

        System.out.println("--------");
        Set<String> strings = map.keySet();
        System.out.println(strings);

        System.out.println("--------");
        Collection<String> values = map.values();
        System.out.println(values);
    }
}
