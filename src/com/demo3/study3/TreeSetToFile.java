package com.demo3.study3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class TreeSetToFile {
    public static void main(String[] args) throws IOException {
        //创建TreeSet集合，重写比较器排序
        TreeSet<DemoStudent> ts = new TreeSet<>(new Comparator<DemoStudent>() {
            @Override
            public int compare(DemoStudent s1, DemoStudent s2) {
                int num1 = s2.getSum() - s1.getSum();
                int num2 = num1 == 0 ? s1.getChinese() - s2.getChinese() : num1;
                int num3 = num2 == 0 ? s1.getMath() - s2.getMath() : num2;
                int num4 = num3 == 0 ? s1.getName().compareTo(s2.getName()) : num3;
                return num4;
            }
        });
        //循环输入五个学生信息
        for (int i = 0; i < 5; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请录入第" + (i + 1) + "位学生信息");
            System.out.println("姓名:");
            String name = sc.nextLine();
            System.out.println("语文成绩:");
            int chinese = sc.nextInt();
            System.out.println("数学成绩:");
            int math = sc.nextInt();
            System.out.println("英语成绩:");
            int english = sc.nextInt();

            //创建学生对象，把键盘输入的值存储到对象中
            DemoStudent s = new DemoStudent();
            s.setName(name);
            s.setChinese(chinese);
            s.setMath(math);
            s.setEnglish(english);

            //学生对象添加到集合
            ts.add(s);

        }
        //创建字符缓冲输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:/StudyTest/ArrayStudent.txt"));

        //遍历集合
        for (DemoStudent ds : ts) {
            StringBuilder sb = new StringBuilder();
            sb.append(ds.getName() + "," + ds.getChinese() + "," + ds.getMath() + "," + ds.getEnglish() + "," + ds.getSum());

            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
