package com.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:   lxs
 * Date:     2022/5/4 23:07
 * Description:
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
//        Files.copy(Paths.get("D:\\Temp\\nsmc\\test\\user\\15687357813\\15687357813.png"), Paths.get("D:\\Temp\\nsmc\\test\\user\\15687357813\\1.png"));
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        updateList(list);
        System.out.println(list);
    }

    private static void updateList(List<Integer> list) {
//        list.remove(1);
        list.remove(new Integer(1));
    }
}
