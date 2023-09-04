package com.test;

import java.util.Arrays;
import java.util.Collections;

/**
 * Author:   xuesong.lei
 * Date:     2022/11/23 21:59
 * Description: 测试
 */
public class ExamineTest {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : array) {
            System.out.println(i);
        }
        Collections.shuffle(Arrays.asList(array));
        for (int i : array) {
            System.out.println(i);
        }
    }
}
