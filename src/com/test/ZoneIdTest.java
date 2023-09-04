package com.test;

import java.time.ZoneId;
import java.util.Set;

/**
 * Author:   lxs
 * Date:     2022/4/29 20:13
 * Description: ZoneId测试类
 */
public class ZoneIdTest {
    public static void main(String[] args) {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        for (String zoneId : zoneIds) {
            System.out.println(zoneId);
        }
    }
}
