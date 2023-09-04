package com.demo3.study11;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;

/**
 * Author:   lxs
 * Date:     2022/5/12 20:17
 * Description: 函数式接口测试
 */
public class FunctionalInterfaceTest {

    @Test
    public void test1() {
        Consumer<String> c1 = System.out::println;
        c1.accept("达州");

        System.out.println("--------------");
        PrintStream ps = System.out;
        Consumer<String> c2 = ps::print;
        c2.accept("大竹");
    }

    @Test
    public void test2() {
        Employee emp = new Employee(4, "Nice", 19, 4200);
        Supplier<String> sk1 = emp::getName;
        System.out.println(sk1.get());
    }

    @Test
    public void test3() {
        Comparator<Integer> com = Integer::compare;
        System.out.println(com.compare(14, 7));
    }

    @Test
    public void test4() {
        Function<Double, Long> function = Math::round;
        System.out.println(function.apply(17.4));
    }

    @Test
    public void test5() {
        Comparator<String> com = String::compareTo;
        System.out.println(com.compare("abd", "abm"));
    }

    @Test
    public void test6() {
        BiPredicate<String, String> predicate = String::equals;
        System.out.println(predicate.test("MON", "MON"));
    }

    @Test
    public void test7() {
        Employee employee = new Employee(7, "Ton", 21, 8000);
        Function<Employee, String> function = Employee::getName;
        System.out.println(function.apply(employee));
    }

    @Test
    public void test8() {
        Supplier<Employee> employeeSupplier = Employee::new;
        System.out.println(employeeSupplier.get());
    }

    @Test
    public void test9() {
        Function<Integer, Employee> function = Employee::new;
        System.out.println(function.apply(4545));
    }

    @Test
    public void test10() {
        BiFunction<Integer, String, Employee> function = Employee::new;
        System.out.println(function.apply(9526, "Lei"));
    }

    @Test
    public void test11() {
        Function<Integer, String[]> function = String[]::new;
        String[] apply = function.apply(9);
        System.out.println(Arrays.toString(apply));
    }
}
