package com.socket.test001;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(5000);
        byte[] msg = new byte[1024];

        DatagramPacket datagramPacket = new DatagramPacket(msg, msg.length);
        System.out.println("Start Listening...");
        datagramSocket.receive(datagramPacket);
        System.out.println("Recieved...");

        String msg_string = new String(datagramPacket.getData(), 0, datagramPacket.getLength());

        System.out.println("message is " + msg_string);

        datagramSocket.close();
    }
}
