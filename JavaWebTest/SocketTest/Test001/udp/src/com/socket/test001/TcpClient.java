package com.socket.test001;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
//        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 8080;
        InetAddress inetAddress = InetAddress.getByName("192.168.3.114");
        Socket socket = new Socket(inetAddress, port);

        OutputStream outputStream = socket.getOutputStream();

        String data = "byebye";
        outputStream.write(data.getBytes());

        outputStream.close();
        socket.close();
    }
}
