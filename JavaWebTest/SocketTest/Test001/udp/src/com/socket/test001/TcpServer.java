package com.socket.test001;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        byte[] msg = new byte[1024];
        int len = inputStream.read(msg);
        String msg_string = new String(msg, 0, len);
        System.out.println("received message is: " + msg_string);
        inputStream.close();
        serverSocket.close();
    }
}
