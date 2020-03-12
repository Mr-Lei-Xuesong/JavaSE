package com.demo3.study4;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo1 {
    public static void main(String[] args) {
        Properties ppt = new Properties();
        ppt.setProperty("ceshi001", "雷雪松");
        ppt.setProperty("ceshi002", "曾玉梅");
        ppt.setProperty("ceshi003", "风清扬");

//        System.out.println(ppt.getProperty("ceshi001"));

        Set<String> names = ppt.stringPropertyNames();
        for (String key : names) {
            String value = ppt.getProperty(key);
            System.out.println(key + "," + value);
        }
    }
}
