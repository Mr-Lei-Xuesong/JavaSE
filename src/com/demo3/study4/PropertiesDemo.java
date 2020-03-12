package com.demo3.study4;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    public static void main(String[] args) {
        Properties ppt = new Properties();

        ppt.put("ceshi001", "雷雪松");
        ppt.put("ceshi002", "曾玉梅");
        ppt.put("ceshi003", "张三丰");

        Set<Object> keySet = ppt.keySet();
        for (Object key : keySet) {
            Object value = ppt.get(key);
            System.out.println(key + "," + value);
        }

    }
}
