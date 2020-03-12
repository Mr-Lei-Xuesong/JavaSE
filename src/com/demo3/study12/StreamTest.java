package com.demo3.study12;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
    两个ArrayList集合，储存了六名女演员。六名男演员
        1.男演员只要名字为三个字的前三人
        2.女演员只要姓林的，不要第一个
        3.把过滤后的男演员和女演员姓名拼在一起
        4.把上一步操作后的元素作为构造方法的参数创建演员对象，遍历数据
 */
public class StreamTest {
    public static void main(String[] args) {
        ArrayList<String> manList=new ArrayList<>();

        manList.add("周润发");
        manList.add("成龙");
        manList.add("刘德华");
        manList.add("吴京");
        manList.add("周星驰");
        manList.add("李连杰");

        ArrayList<String> womanList=new ArrayList<>();

        womanList.add("林心如");
        womanList.add("张曼玉");
        womanList.add("王祖贤");
        womanList.add("林青霞");
        womanList.add("刘岩");
        womanList.add("林志玲");

        /*//男演员只要名字为三个字的前三人
        Stream<String> man = manList.stream().filter(s -> s.length() == 3).limit(3);

        //女演员只要姓林的，不要第一个
        Stream<String> woman = womanList.stream().filter(s -> s.startsWith("林")).skip(1);

        //把过滤后的男演员和女演员姓名拼在一起
        Stream<String> concat = Stream.concat(man, woman);
        concat.map(Actor::new).forEach(p-> System.out.println(p.getName()));*/

        Stream.concat(manList.stream().filter(s -> s.length() == 3).limit(3),
                womanList.stream().filter(s -> s.startsWith("林")).skip(1))
                .map(Actor::new).forEach(p-> System.out.println(p.getName()));
    }
}
