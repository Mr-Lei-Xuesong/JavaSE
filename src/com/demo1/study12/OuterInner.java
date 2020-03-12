package com.demo1.study12;

public class OuterInner {
    public void method() {
        Inner i = new Inner() {
            @Override
            public void show() {
                System.out.println("匿名内部类");
            }
        };
        i.show();
        i.show();

        Zi z = new Zi() {
            @Override
            public void method() {
                System.out.println("继承类");
            }
        };
        z.method();
    }
}
