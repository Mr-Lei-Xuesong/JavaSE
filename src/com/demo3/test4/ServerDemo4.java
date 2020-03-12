package com.demo3.test4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo4 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10040);

        while (true) {
            //监听客户端的连接，返回一个对应的Socket
            Socket s = ss.accept();
            //为每个客户端开启一个线程
            new Thread(new ServerThread(s)).start();
        }
    }
}
