package com.demo3.study11;

import java.util.function.Predicate;

public class PredicateDemo1 {
    public static void main(String[] args) {
        boolean b1 = checkString1("hello", s -> s.length() > 4);
        System.out.println(b1);

        System.out.println("--------");
        boolean b2 = checkString2("hello", s -> s.length() > 4);
        System.out.println(b2);

        System.out.println("--------");
        boolean b3 = checkString3("helloworld", s -> s.length() > 8, s -> s.length() < 15);
        System.out.println(b3);

        System.out.println("--------");
        boolean b4 = checkString3("hello", s -> s.length() > 0, s -> s.length() >9);
        System.out.println(b4);
    }

    private static boolean checkString1(String s, Predicate<String> pre){
        return pre.test(s);
    }

    private static boolean checkString2(String s, Predicate<String> pre){
        return pre.negate().test(s);//逻辑非
    }

    private static boolean checkString3(String s,Predicate<String> pre1,Predicate<String> pre2){
        return pre1.and(pre2).test(s);//逻辑与
    }

    private static boolean checkString4(String s,Predicate<String> pre1,Predicate<String> pre2){
        return pre1.or(pre2).test(s);//逻辑或
    }
}
