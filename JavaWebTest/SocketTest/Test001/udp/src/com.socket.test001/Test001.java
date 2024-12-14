package com.socket.test001;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class Test001 {
    /**
     * 使用java获取 IP
     */
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("192.168.31.42"); // 填 "127.0.0.1" 或 "localhost" 代表本机
        // 获取当前 IP 的主机名
        String hostName = inetAddress.getHostName();
        System.out.println("hostname = " + hostName);
        // 获取当前 IP 地址
        String hostAddress = inetAddress.getHostAddress();
        System.out.println("hostaddress = " + hostAddress);

        InetAddress inetAddress1 = inetAddress.getLocalHost();
        // 获取本机 IP 地址
        System.out.println("LocalHostName = " + inetAddress1.getHostName());
        System.out.println("LocalHostAddress = " + inetAddress1.getHostAddress());
    }
}
