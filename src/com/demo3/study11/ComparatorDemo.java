package com.demo3.study11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        ArrayList<String> array=new ArrayList<>();
        array.add("cccc");
        array.add("aa");
        array.add("b");
        array.add("ddd");

        System.out.println("排序前:"+array);

        /*Collections.sort(array);
        System.out.println("排序后:"+array);*/

        array.sort(getComparator());
        System.out.println("排序后:"+array);

    }

    private static Comparator<String> getComparator(){
        //匿名内部类的方式实现
        /*Comparator<String> comp=new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length()-s2.length();
            }
        };
        return comp;*/
        /*return new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length()-s2.length();
            }
        };*/

        return (s1,s2)->s1.length()-s2.length();
    }
}
