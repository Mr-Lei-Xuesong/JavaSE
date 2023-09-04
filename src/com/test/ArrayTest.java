package com.test;

/**
 * Author:   lxs
 * Date:     2022/5/25 14:42
 * Description:
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] nums = {1,2,3,-1,5,7};
        System.out.println(maxSum(nums));
    }

    public static int maxSum(int[] array) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int subOfArr = 0;
            for (int j = i; j < array.length; j++) {
                subOfArr += array[j];
                if (subOfArr > sum) {
                    sum = subOfArr;
                }
            }
        }
        return sum;
    }
}
