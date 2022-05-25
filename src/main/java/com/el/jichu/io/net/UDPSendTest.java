package com.el.jichu.io.net;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author roman zhangfei
 * @Date 2019/12/27 9:19
 * @Version V1.0
 */
public class UDPSendTest {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        InetAddress address = InetAddress.getByName("10.17.86.214");

        int port = 7070;

        byte[] bytes ;

        while(true){
            System.out.println("发送的信息：");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();

            bytes = line.getBytes();

            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, port);

            socket.send(packet);

            if (line.equals("exit")) {
                break;
            }
        }
        socket.close();
    }
}