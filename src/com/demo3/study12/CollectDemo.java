package com.demo3.study12;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectDemo {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("林青霞");
        list.add("雷雪松");
        list.add("柳岩");
        list.add("曾玉梅");

        //得到名字三个字的流
        Stream<String> listName = list.stream().filter(s -> s.length() == 3);

        //新得到的流收集到List集合中
        List<String> names = listName.collect(Collectors.toList());
        for (String s:names){
            System.out.println(s);
        }

        System.out.println("--------");
        Set<Integer> set=new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(33);
        set.add(35);

        //得到年龄大于25的流
        Stream<Integer> setStream = set.stream().filter(s -> s > 25);

        Set<Integer> age = setStream.collect(Collectors.toSet());
        for (Integer i:age){
            System.out.println(i);
        }

        System.out.println("--------");
        String[] strArray={"林青霞,30","张曼玉,35","王祖贤,33","柳岩,25"};
        Stream<String> arrayStream = Stream.of(strArray).filter(s -> Integer.parseInt(s.split(",")[1]) > 28);

        Map<String, Integer> map = arrayStream.collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.parseInt(s.split(",")[1])));
        Set<String> keySet = map.keySet();
        for (String key:keySet){
            Integer value = map.get(key);
            System.out.println(key+","+value);
        }
    }
}
