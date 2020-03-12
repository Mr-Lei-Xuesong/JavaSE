package com.demo3.study10;

public class PrintableDemo {
    public static void main(String[] args) {
//        uesPrintable(i -> System.out.println(i));
        uesPrintable(System.out::println);
    }

    public static void uesPrintable(Printable p){
        p.printInt(666);
    }
}
