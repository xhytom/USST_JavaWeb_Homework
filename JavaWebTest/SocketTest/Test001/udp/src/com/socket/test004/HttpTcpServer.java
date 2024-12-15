package com.socket.test004;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpTcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    OutputStream outputStream = null;
                    try {
                        outputStream = socket.getOutputStream();
                        File file = new File("C:\\Users\\10042\\Desktop\\2024-2025上学期\\JavaWeb\\USST_JavaWeb_Homework\\onlinestore\\storeapp\\store\\templates\\store\\list_goods.html");

                        FileInputStream fileInputStream = new FileInputStream(file);

                        byte[] msg = new byte[102400];
                        int len = fileInputStream.read(msg);
                        outputStream.write(msg, 0, len);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }).start();

        }
    }
}
