package com.test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Author:   lxs
 * Date:     2022/9/26 22:22
 * Description:
 */
public class TestArray {
    public static void main(String[] args) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            System.out.println(list);
            for(int i : list){
                if (i == 1){
                    list.remove(i);
                }
            }
            System.out.println(list);

    }
}
