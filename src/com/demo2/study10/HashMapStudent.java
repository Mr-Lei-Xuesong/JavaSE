package com.demo2.study10;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapStudent {
    public static void main(String[] args) {
        Map<String, Student> map = new HashMap<>();
        Student s1 = new Student("雷雪松", 22);
        Student s2 = new Student("曾玉梅", 21);
        Student s3 = new Student("雪妹仔", 20);
        map.put("001", s1);
        map.put("002", s2);
        map.put("003", s3);

        Set<String> keySet = map.keySet();//获取键
        for (String s : keySet) {//遍历键
            Student student = map.get(s);//获取值
            System.out.println(s + "," + student.getName() + ":" + student.getAge());
        }

        System.out.println("--------");
        Set<Map.Entry<String, Student>> entries = map.entrySet();//获取键值对的数据
        for (Map.Entry<String, Student> me : entries) {//遍历键值对数据
            String key = me.getKey();//获取键
            Student value = me.getValue();//获取值
            System.out.println(key + "," + value.getName() + ":" + value.getAge());
        }
    }
}
