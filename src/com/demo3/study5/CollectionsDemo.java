package com.demo3.study5;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        Set<String> set = Collections.synchronizedSet(new HashSet<String>());
        Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());

        StringBuffer sb = new StringBuffer();
        Vector<String> vt = new Vector<>();
        Hashtable<String, String> ht = new Hashtable<>();

    }
}
