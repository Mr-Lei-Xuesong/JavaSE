package com.demo1.study11;

public class PersonDemo {
    public static void main(String[] args) {
        PingPangCoach ppc = new PingPangCoach();
        ppc.setName("小明");
        ppc.setAge(41);
        System.out.println(ppc.getName() + ", " + ppc.getAge());
        ppc.eat();
        ppc.teach();
        ppc.speak();

        System.out.println("--------");

        PingPangPlayer ppp = new PingPangPlayer();
        ppp.setName("雷雪松");
        ppp.setAge(21);
        System.out.println(ppp.getName() + ", " + ppp.getAge());
        ppp.eat();
        ppp.study();
        ppp.speak();

        System.out.println("--------");

        BasketballCoach bbc = new BasketballCoach("乔丹", 37);
        System.out.println(bbc.getName() + ", " + bbc.getAge());
        bbc.eat();
        bbc.teach();

        System.out.println("--------");

        BasketballPlayer bbp = new BasketballPlayer("姚明", 35);
        System.out.println(bbp.getName() + ", " + bbp.getAge());
        bbp.eat();
        bbp.study();
    }
}
