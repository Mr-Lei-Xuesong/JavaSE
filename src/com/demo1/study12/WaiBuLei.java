package com.demo1.study12;

public class WaiBuLei {
    private int age = 30;

    public class NeiBuLei {
        private void test() {
            System.out.println(age);
        }
    }

    public void test1() {
//        test();
        NeiBuLei nbl = new NeiBuLei();
        nbl.test();
    }
}

