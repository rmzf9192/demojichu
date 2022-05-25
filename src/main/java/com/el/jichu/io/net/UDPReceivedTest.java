package com.el.jichu.io.net;

import java.io.IOException;
import java.net.*;

/**
 * @author roman zhangfei
 * @Date 2019/12/27 9:13
 * @Version V1.0
 */
public class UDPReceivedTest {
    public static void main(String[] args) throws IOException {

        InetAddress address = InetAddress.getByName("10.17.86.214");
        DatagramSocket socket = new DatagramSocket(7070,address);

        byte[] bytes = new byte[100];

        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);


        System.out.println("等待着。。。");

        while(true){
            socket.receive(packet);

            String s = new String(packet.getData(), 0, packet.getLength());
            System.out.println("我收到了："+s);
            if (s.equals("exit")) {
                break;
            }
        }
        socket.close();
    }
}