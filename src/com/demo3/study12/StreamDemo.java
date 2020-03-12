package com.demo3.study12;

import java.util.*;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        Stream<String> listStream = list.stream();

        Set<String> set=new HashSet<>();
        Stream<String> setStream = set.stream();

        Map<String,String> map=new HashMap<>();
        Stream<String> mapStream = map.keySet().stream();
        Stream<String> mapStream1 = map.values().stream();
        Stream<String> maoStream2 = map.keySet().stream();

        String[] strArray={"hello","world","java"};
        Stream<String> strArray1 = Stream.of(strArray);

        Stream<String> hello = Stream.of("hello", "world", "java");
    }
}
