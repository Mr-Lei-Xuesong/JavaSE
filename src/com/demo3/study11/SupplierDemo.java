package com.demo3.study11;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        String s = getString(() -> "林青霞");
        System.out.println(s);
        Integer i = getInteger(() -> 30);
        System.out.println(i);

        int[] arr = {18, 65, 92, 46, 75};

        Integer ig = getMax(() -> {
            int max = arr[0];
            for (int is = 0; is < arr.length; is++) {
                if (arr[is] > max) {
                    max = arr[is];
                }
            }
            return max;
        });

        System.out.println(ig);
    }

    private static String getString(Supplier<String> sup) {
        return sup.get();
    }

    private static Integer getInteger(Supplier<Integer> sup) {
        return sup.get();
    }

    private static Integer getMax(Supplier<Integer> sup) {
        return sup.get();
    }
}
