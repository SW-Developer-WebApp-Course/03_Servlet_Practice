package com.section02.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Application {
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(8080);

        //요청 횟수 집계
        int count = 1;
        try{
            System.out.println("HTTP Server started at 8080 port");
            Socket socket = listener.accept();

            while (true) {
                try {
                    System.out.println("New Client Connect! Connected IP: "
                            + socket.getInetAddress()
                            + ", Port: "
                            + socket.getPort() + "\n");

                    count++;

                    int value = 0;
                    InputStream in = socket.getInputStream();
                    OutputStream out = socket.getOutputStream();

                    while ((value = in.read()) != -1 && count == 3){
                        System.out.println((char) value);
                    }

                    String responseText = "<h1>Hello World</h1>";

                    String responseGeneralHeader = "HTTP/1.1 200 OK\r\n";
                    String contentType = "Content-Type: text/html; charset=utf-8";
                    String contentLength = "Content-Length: " + responseText.length() + "\r\n";
                    String whiteLine = "\r\n";

                    out.write(responseGeneralHeader.getBytes());
                    out.write(contentType.getBytes());
                    out.write(contentLength.getBytes());
                    out.write(whiteLine.getBytes());

                    out.write(responseText.getBytes());
                    out.write(whiteLine.getBytes());

                    out.flush();
                } finally {
                socket.close();
                }
            }
        } finally {
            listener.close();
        }
    }
}
