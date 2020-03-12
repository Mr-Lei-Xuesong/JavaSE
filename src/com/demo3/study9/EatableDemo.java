package com.demo3.study9;

public class EatableDemo {
    public static void main(String[] args) {
        Eatable e=new EatableImpl();
        useEatable(e);

        useEatable(new Eatable() {
            @Override
            public void eat() {
                System.out.println("医生远离我，一天一苹果");
            }
        });

        useEatable(()->{
            System.out.println("一天一苹果，医生远离我");
        });
    }
    public static void useEatable(Eatable e){
        e.eat();
    }
}
