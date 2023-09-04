package com.demo3.study7;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress byName = InetAddress.getByName("lxsblogs.cn");
        String hostName = byName.getHostName();
        String hostAddress = byName.getHostAddress();
        System.out.println("主机名:" + hostName);
        System.out.println("主机IP地址:" + hostAddress);

        System.out.println("---------------");
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("localHost:"+localHost);
        System.out.println("HostName:"+localHost.getHostName());
        System.out.println("HostAddress:"+localHost.getHostAddress());
    }
}
