package com.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author:   lxs
 * Date:     2021/10/21 12:47
 * Description: 随机输入一个整数，翻转该数，每个位存放在数组中，并输出翻转后的数，若高位为0则保留
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 10);
            num = num / 10;
        }
        for (Integer integer : list) {
            System.out.print(integer);
        }
    }
}
