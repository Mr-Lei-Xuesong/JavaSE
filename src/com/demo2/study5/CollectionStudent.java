package com.demo2.study5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionStudent {
    public static void main(String[] args) {
        Collection<Student> c=new ArrayList<>();
        Student s1=new Student("雷雪松",22);
        Student s2=new Student("曾玉梅",20);
        Student s3=new Student("雷小松",18);

        c.add(s1);
        c.add(s2);
        c.add(s3);

        Iterator<Student> i = c.iterator();
        while (i.hasNext()){
            Student next = i.next();
            System.out.println(next.getName()+", "+next.getAge());
        }
    }
}
