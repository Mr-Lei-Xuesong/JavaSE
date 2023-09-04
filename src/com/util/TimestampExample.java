package com.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: xuesong.lei
 * @Date: 2023/4/25 15:19
 * @Description:
 */
public class TimestampExample {
    public static void main(String[] args) throws InterruptedException {
        String originalText = "《甄选公告模板终止流程&&I21302710612001》请求处理审批";
        String modifiedText = removeDataBetween(originalText, "&&", "》");

        System.out.println("修改前: " + originalText);
        System.out.println("修改后: " + modifiedText);

    }

    private static String removeDataBetween(String text, String startPattern, String endPattern) {
        int startIndex = text.indexOf(startPattern);
        int endIndex = text.indexOf(endPattern);
        if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
            return text.substring(0, startIndex) + text.substring(endIndex);
        } else {
            return text;
        }
    }
}
