package com.socket.test002;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        int port = 8080;
//        InetAddress inetAddress = InetAddress.getByName("192.168.3.114");
        InetAddress inetAddress = InetAddress.getByName("localhost");
        while (true) {
            Socket socket = new Socket(inetAddress, port);
            System.out.println("Client: Please input message");
            Scanner scanner = new Scanner(System.in);
            String context = scanner.next();
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(context.getBytes());

            byte[] msg = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            int len = inputStream.read(msg);
            String msg_string = new String(msg, 0, len);
            System.out.println("Received message: " + msg_string);
            outputStream.close();
            socket.close();
            if (msg_string.equals("byebye")) {
                break;
            }
        }
    }
}
