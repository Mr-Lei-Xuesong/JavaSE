package com.demo3.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo1 {
    public static void main(String[] args) throws IOException {
        //创建服务器对象
        ServerSocket ss = new ServerSocket(10010);

        //监听客户端的连接，返回一个对应的Socket
        Socket accept = ss.accept();

        //封装输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println("客户端数据:" + line);
        }

        //释放资源
        ss.close();
    }
}
