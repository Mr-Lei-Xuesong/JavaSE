package com.demo2.study2;

import org.junit.Test;

/**
 * Author:   lxs
 * Date:     2022/3/27 16:12
 * Description: String测试类
 */
public class StringTest {

    /**
     * 常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量
     * 如果其中有一个是变量，结果就在堆中
     * 如果拼接的结果调用intern()方法，返回值就在常量池中
     */
    @Test
    public void test() {
        String s1 = "JavaSE";
        String s2 = "Hadoop";

        String s3 = "JavaSEHadoop";
        String s4 = "JavaSE" + "Hadoop";
        String s5 = s1 + "Hadoop";
        String s6 = "JavaSE" + s2;
        String s7 = s1 + s2;

        String s8 = s5.intern();

        System.out.println(s3 == s4);//
        System.out.println(s3 == s5);//
        System.out.println(s3 == s6);//
        System.out.println(s3 == s7);//
        System.out.println(s5 == s6);//
        System.out.println(s5 == s7);//
        System.out.println(s6 == s7);//

        System.out.println(s3 == s8);//

    }

    @Test
    public void testLength() {
        int[][] arr = new int[10][];
        for (int i = 0; i < arr.length; i++) {
            //为每一行初始化容量
            arr[i] = new int[i + 1];
            //为每行首位赋值
            arr[i][0] = arr[i][i] = 1;
            //为每行的非首末赋值
            for (int j = 1; j < arr[i].length - 1; j++) {
                //该值为上一排元素和前一个元素之和
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
