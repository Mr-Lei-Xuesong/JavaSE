package com.demo3.test2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10020);

        //监听客户端的连接，返回一个对应的Socket
        Socket s = ss.accept();

        //接受数据
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        //把数据写入到文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:/StudyTest/ServerDemo2.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //关闭资源
        bw.close();
        ss.close();
    }
}
