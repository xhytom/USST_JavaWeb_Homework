package com.socket.test001;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
    /**
     * 1. 创建发送端socket对象
     * 2.
     */
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String msg = "Zaijian 再见";
        byte[] msg_byte = msg.getBytes();
//        InetAddress inetAddress = InetAddress.getByName("150.158.79.12");
//        InetAddress inetAddress = InetAddress.getByName("localhost");
//        InetAddress inetAddress = InetAddress.getByName("192.168.31.42");
        InetAddress inetAddress = InetAddress.getByName("192.168.3.151");
        int port = 5000;
        DatagramPacket datagramPacket = new DatagramPacket(msg_byte, msg_byte.length, inetAddress, port);

        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
