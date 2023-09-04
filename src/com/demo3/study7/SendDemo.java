package com.demo3.study7;

import java.io.IOException;
import java.net.*;

public class SendDemo {
    public static void main(String[] args) throws IOException {
        //创建发送端的Socket对象(DatagramSocket)
        DatagramSocket ds = new DatagramSocket();

        //创建数据，并把数据打包
        byte[] bys = "hello,udp,我来了".getBytes();
        /*int length = bys.length;
        InetAddress address = InetAddress.getByName("192.168.56.1");
        int port=10086;*/
//        DatagramPacket dp=new DatagramPacket(bys,length,address,port);

        DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName("127.0.0.1"), 10068);
        //发送数据
        ds.send(dp);
        //关闭发送端
        ds.close();
    }
}
