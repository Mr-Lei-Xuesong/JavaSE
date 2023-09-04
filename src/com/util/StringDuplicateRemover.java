package com.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @Author: xuesong.lei
 * @Date: 2023/4/14 9:50
 * @Description: 字符串去重
 */
public class StringDuplicateRemover {
    public static void main(String[] args) {
        // 文件路径
        String filePath = "D:\\Project\\BackEndProjects\\JavaSE\\src\\com\\util\\repeat.txt";

        // 读取文件内容
        String fileContent = readFileContent(filePath);

        // 使用逗号作为分隔符，将文件内容拆分为数组
        String[] contentArray = fileContent.split(",");


        // 使用Set集合去重
        Set<String> uniqueSet = new HashSet<>();
        Collections.addAll(uniqueSet, contentArray);

        // 将Set集合转换为List集合
        List<String> uniqueList = new ArrayList<>(uniqueSet);

        // 将List集合转换为字符串
        String resultStr = String.join(",", uniqueList);
        System.out.println(resultStr);
    }

    private static String readFileContent(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
