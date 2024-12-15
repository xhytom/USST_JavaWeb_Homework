package com.socket.test004;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpTcpServerPro {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    OutputStream outputStream = null;
                    InputStream inputStream = null;
                    try {
                        inputStream = socket.getInputStream();
                        outputStream = socket.getOutputStream();

                        byte[] reqByte = new byte[10240];
                        int reqlen = inputStream.read(reqByte);
                        String req = new String(reqByte, 0, reqlen);
                        System.out.println(req);

                        String url = req.split("\r\n")[0].split(" ")[1];
                        System.out.println(url);

                        File file = new File("C:\\Users\\10042\\Desktop\\2024-2025上学期\\JavaWeb\\USST_JavaWeb_Homework\\onlinestore\\storeapp\\store\\templates\\store" + url);

                        FileInputStream fileInputStream = new FileInputStream(file);

                        byte[] msg = new byte[102400];
                        int len = fileInputStream.read(msg);
                        outputStream.write(msg, 0, len);
                    } catch (Exception e) {
                        e.printStackTrace();
                        try {
                            outputStream.write("500".getBytes());
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    } finally {
                        try {
                            if (outputStream != null)
                                outputStream.close();
                            if (inputStream != null)
                                inputStream.close();
                            if (socket != null)
                                socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }
    }
}
