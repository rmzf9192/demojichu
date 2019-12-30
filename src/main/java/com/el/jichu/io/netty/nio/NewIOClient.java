package com.el.jichu.io.netty.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Scanner;

/**
 * @author roman zhangfei
 * @Date 2019/12/30 11:46
 * @Version V1.0
 */
public class NewIOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel soc = SocketChannel.open();

        soc.connect(new InetSocketAddress("127.0.0.1",7001));

        String fileName = "E:\\study\\1.txt";

        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        long start = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));

        long transferCount = fileChannel.transferTo(0, fileChannel.size(), soc);

        System.out.println("发送的总字节数："+(transferCount + LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"))-start));

        Scanner scanner = new Scanner(System.in);

        String next = scanner.next();
        while(next !=null){
            System.out.println("输入的内容："+next);
        }
        fileChannel.close();

    }
}