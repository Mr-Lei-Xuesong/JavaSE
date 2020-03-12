package com.demo3.test3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo3 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10030);

        //监听客户端的连接，返回一个对应的Socket
        Socket s = ss.accept();

        //接受数据
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        //把数据写入到文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:/StudyTest/Copy.java"));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //给客户端反馈
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bfw.write("文件上传成功");
        bfw.newLine();
        bfw.flush();

        //关闭资源
        bw.close();
        ss.close();
    }
}
