package com.demo3.study7;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress byName = InetAddress.getByName("192.168.56.1");
        String hostName = byName.getHostName();
        String hostAddress = byName.getHostAddress();
        System.out.println("主机名:" + hostName);
        System.out.println("主机IP地址:" + hostAddress);

    }
}
