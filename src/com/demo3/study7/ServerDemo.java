package com.demo3.study7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //创建服务器端的Socket对象(**ServerSocket**)
        ServerSocket ss = new ServerSocket(10086);

        //监听客户端连接，返回一个Socket对象
        Socket accept = ss.accept();

        //获取输入流，读数据，并把数据显示在控制台
        InputStream is = accept.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String data = new String(bys, 0, len);
        System.out.println("服务器:" + data);

        //给客户端反馈
        OutputStream os = accept.getOutputStream();
        os.write("数据已经收到".getBytes());

        //释放资源
        ss.close();
    }
}
