package com.el.jichu.io.net;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author roman zhangfei
 * @Date 2019/12/27 9:36
 * @Version V1.0
 */
public class TCPServerTest {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(7070,10000,InetAddress.getByName("10.17.86.214"));

        System.out.println("开启服务");

        while(true){
            Socket accept = socket.accept();

            System.out.println("有人连接了");

            InputStream inputStream = accept.getInputStream();

            DataInputStream dataInputStream = new DataInputStream(inputStream);

            String readUTF = dataInputStream.readUTF();
            System.out.println("内容："+readUTF);
        }
    }
}