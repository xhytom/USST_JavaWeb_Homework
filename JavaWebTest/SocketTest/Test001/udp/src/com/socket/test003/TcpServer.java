package com.socket.test003;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server OK!");
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream inputStream = socket.getInputStream();
                        byte[] msg = new byte[1024];

                        int len = inputStream.read(msg);

                        String msg_string = new String(msg, 0, len);

                        System.out.println("Received " + msg_string);
                        OutputStream outputStream = socket.getOutputStream();
                        if (msg_string.equals("byebye")) {
                            outputStream.write("byebye".getBytes());
                        }

                        System.out.println("Please reply a message \"" + msg_string + "\" :");
                        Scanner scanner = new Scanner(System.in);
                        String resp = scanner.next();
                        outputStream.write(resp.getBytes());
                        inputStream.close();
                        outputStream.close();
                        socket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
    }
}
