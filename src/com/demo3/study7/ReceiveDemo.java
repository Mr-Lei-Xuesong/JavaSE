package com.demo3.study7;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        //创建接收端的Socket对象(DatagramSocket)
        DatagramSocket ds = new DatagramSocket(10068);

        //创建一个数据包，用于接受数据
        byte[] bys = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bys, bys.length);

        //调用DatagramSocket对象的方法接受数据
        ds.receive(dp);

        //解析数据包，并把数据在控制台显示
        /*byte[] data = dp.getData();
        int length = dp.getLength();
        String datas=new String(data,0,length);
        System.out.println("数据是:"+datas);*/
        System.out.println("数据是:" + new String(dp.getData(), 0, dp.getLength()));

        //关闭接收端
        ds.close();
    }
}
