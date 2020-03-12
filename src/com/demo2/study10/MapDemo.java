package com.demo2.study10;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("郭靖", "黄蓉");
        map.put("杨过", "小龙女");
        map.put("张无忌", "赵敏");

        Set<String> strings = map.keySet();
        for (String s : strings) {
            String s1 = map.get(s);
            System.out.println(s + ":" + s1);
        }

        System.out.println("--------");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> me : entries) {
            /*System.out.println(me);
            System.out.println("--------");*/
            System.out.println(me.getKey() + ":" + me.getValue());
        }
    }
}
