package com.demo3.study10;

public class ConverterDemo {
    public static void main(String[] args) {
        /*uesConverter((String s)->{
            return Integer.parseInt(s);
        });*/
        uesConverter(Integer::parseInt);

    }

    public static void uesConverter(Converter c){
        int number = c.converter("666");
        System.out.println(number);
    }
}
