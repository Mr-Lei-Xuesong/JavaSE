package com.demo3.test4;

import java.io.*;
import java.net.Socket;

public class ClientDemo4 {
    public static void main(String[] args) throws IOException {
        //创建客户端对象
        Socket s = new Socket("192.168.56.1", 10040);

        //从文件读取数据
        BufferedReader br = new BufferedReader(new FileReader("E:/StudyTest/CopyPokerDemo2.java"));
        //封装输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        s.shutdownOutput();

        //接受服务器反馈
        BufferedReader bfr = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String data = bfr.readLine();
        System.out.println("服务器的反馈" + data);

        br.close();
        s.close();
    }
}
