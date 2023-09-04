package com.test;

/**
 * Author:   lxs
 * Date:     2022/4/13 8:46
 * Description: String测试类
 */
public class StringTest {

    public static void main(String[] args) {
        /*String str = "    a    ";
        String trim = trim(str);
        System.out.println(trim);*/

        /*String str = "abcdefg";
        String reverse = reverse(str, 2, 5);
        System.out.println(reverse);*/

        String mainStr = "abkkcadkabkebfkabkskab";
        String subStr = "ab";
        int count = getCount(mainStr, subStr);
        System.out.println(count);
    }

    /**
     * 取出字符串两边空格
     */
    public static String trim(String str) {
        if (str != null) {
            int start = 0;
            int end = str.length() - 1;
            while (start < end && str.charAt(start) == ' ') {
                start++;
            }
            while (start < end && str.charAt(end) == ' ') {
                end--;
            }
            if (str.charAt(start) == ' ') {
                return "";
            }
            return str.substring(start, end + 1);
        }
        return null;
    }

    /**
     * 字符串的反转
     *
     * @param str        字符串
     * @param startIndex 起始
     * @param endIndex   结束
     * @return 反转的字符串
     */
    public static String reverse(String str, int startIndex, int endIndex) {
        if (str != null && str.length() != 0) {
            char[] arr = str.toCharArray();
            for (int x = startIndex, y = endIndex; x < y; x++, y--) {
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    /**
     * 获取指定字符出现次数
     *
     * @param mainStr 原字符串
     * @param subStr  指定字符串
     * @return 出现次数
     */
    public static int getCount(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if (mainLength >= subLength) {
            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                count++;
                index += subLength;
            }
            return count;
        } else {
            return 0;
        }
    }
}
