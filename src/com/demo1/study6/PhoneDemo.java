package com.demo1.study6;

public class PhoneDemo {
    public static void main(String[] args) {
        Phone p = new Phone();
        p.call("雷雪松");

        System.out.println("----------");
        NewPhone np = new NewPhone();
        np.call("曾玉梅");
    }
}
