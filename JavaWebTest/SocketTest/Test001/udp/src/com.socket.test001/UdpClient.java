package com.socket.test001;

import java.io.IOException;
import java.net.*;

public class UdpClient {
    /**
     * 1. 创建发送端socket对象
     * 2.
     */
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String msg = "shabi zzj";
        byte[] msg_byte = msg.getBytes();
//        InetAddress inetAddress = InetAddress.getByName("150.158.79.12");
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 8080;
        DatagramPacket datagramPacket = new DatagramPacket(msg_byte, msg_byte.length, inetAddress, port);

        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
