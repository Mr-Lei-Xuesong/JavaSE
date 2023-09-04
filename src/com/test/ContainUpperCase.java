package com.test;

/**
 * @Author: xuesong.lei
 * @Date: 2023/3/31 16:11
 * @Description: 判断字符串是否包含大写字母
 */
public class ContainUpperCase {

    public static void main(String[] args) {
        ContainUpperCase containUpperCase = new ContainUpperCase();
        System.out.println(containUpperCase.isContainUpperCase("abc"));
        System.out.println(containUpperCase.isContainUpperCase("ADR"));
        System.out.println(containUpperCase.isContainUpperCase("ABC_B"));
    }

/*    private boolean isContainUpperCase(String str) {
        StringBuilder buf = new StringBuilder(str);
        for (int i = 0; i < buf.length(); i++) {
            if (Character.isLowerCase(buf.charAt(i))) {
                return false;
            }
        }
        return true;
    }*/

    private boolean isContainUpperCase(String str) {
        StringBuilder buf = new StringBuilder(str);
        for (int i = 0; i < buf.length(); i++) {
            if (Character.isLowerCase(buf.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
