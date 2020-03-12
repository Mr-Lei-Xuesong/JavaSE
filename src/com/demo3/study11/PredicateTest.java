package com.demo3.study11;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        String[] strArray={"林青霞,30","刘岩,34","张曼玉,35","貂蝉,31","王祖贤,33"};

        ArrayList<String> array = myFile(strArray, s -> s.split(",")[0].length() > 2, s -> Integer.parseInt(s.split(",")[1]) > 33);

        for (String str:array){
            System.out.println(str);
        }
    }

    private static ArrayList<String> myFile(String[] strArray, Predicate<String> pre1,Predicate<String> pre2){
        //定义集合
        ArrayList<String> array=new ArrayList<>();

        //遍历
        for (String str:strArray){
            if (pre1.and(pre2).test(str)){
                array.add(str);
            }
        }

        return array;
    }
}
