package com.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author:   lxs
 * Date:     2022/8/24 12:10
 * Description: Stream流测试
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> collect = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        System.out.println(collect);

    }
}
