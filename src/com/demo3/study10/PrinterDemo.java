package com.demo3.study10;

public class PrinterDemo {
    public static void main(String[] args) {
        usePrinter((String s)->{
            String s1 = s.toUpperCase();
            System.out.println(s1);
        });

        PrintString ps=new PrintString();
        usePrinter(ps::printUpper);
    }

    public static void usePrinter(Printer p){
        p.printUpperCase("HelloWorld");
    }
}
