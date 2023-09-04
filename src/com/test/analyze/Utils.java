package com.test.analyze;

import java.util.*;

/**
 * Author:   lxs
 * Date:     2022/5/19 19:14
 * Description:
 */
public class Utils {

    public static List<Symbol> createSymbolsByString(String str) {
        List<Symbol> symbolList = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            symbolList.add(Alphabet.getSymbol(ch));
        }
        return symbolList;
    }

    public static <T> List<T> asList(T... ts) {
        List<T> list = new ArrayList<>();
        for (T t : ts) {
            list.add(t);
        }
        return list;
    }

    public static <T> Set<T> asSet(T... ts) {
        Set<T> set = new HashSet<>();
        for (T t : ts) {
            set.add(t);
        }
        return set;
    }

    public static <OuterK, InnerK, InnerV> InnerV addToDoubleMap(
            Map<OuterK, Map<InnerK, InnerV>> outerMap, OuterK outerK, InnerK innerK, InnerV innerV) {
        Map<InnerK, InnerV> innerMap = outerMap.get(outerK);
        if (innerMap == null) {
            innerMap = new HashMap<>();
            outerMap.put(outerK, innerMap);
        }
        return innerMap.put(innerK, innerV);
    }

    public static <OuterK, InnerK, InnerV> void addToDoubleMapPrintConflict(
            Map<OuterK, Map<InnerK, InnerV>> outerMap, OuterK outerK, InnerK innerK, InnerV innerV, String format) {
        InnerV old = addToDoubleMap(outerMap, outerK, innerK, innerV);
        if (old != null && !old.equals(innerV)) {
            System.out.println(String.format(format, old, innerV));
        }
    }
}
