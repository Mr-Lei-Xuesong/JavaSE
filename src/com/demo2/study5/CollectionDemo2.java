package com.demo2.study5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo2 {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(1);
        c.add(2);
        Iterator<Integer> i = c.iterator();
        while (i.hasNext()) {
            Integer next = i.next();
            System.out.println(next);
        }
    }
}
