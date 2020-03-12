package com.demo3.study7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //创建客户端的Socket对象(**Socket**)
        Socket sk = new Socket("192.168.56.1", 10086);

        //获取输出流，写数据
        OutputStream os = sk.getOutputStream();
        os.write("hello,tcp,我来了".getBytes());

        //接受服务器反馈
        InputStream is = sk.getInputStream();
        byte[] bt = new byte[1024];
        int len = is.read(bt);
        String data = new String(bt, 0, len);
        System.out.println("客户端" + data);

        //释放资源
        sk.close();
    }
}
