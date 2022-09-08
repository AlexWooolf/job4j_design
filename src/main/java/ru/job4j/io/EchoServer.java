package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String string = in.readLine();
                    if (string.contains("Bye") || string.contains("Exit")) {
                        server.close();
                    } else if (string.contains("Hello")) {
                        out.write("Hello! \r\n\r\n".getBytes());
                    } else {
                        String msg = string.substring(string.lastIndexOf("msg=") + 4);
                        out.write((msg + "\r\n\r\n").getBytes());
                    }
                    out.flush();
                }
            }
        }
    }
}