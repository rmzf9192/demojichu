package com.el.jichu.io.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author roman zhangfei
 * @Date 2019/12/30 11:40
 * @Version V1.0
 */
public class NewIoServer {
    public static void main(String[] args) throws IOException {
        InetSocketAddress addrees = new InetSocketAddress(7001);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        ServerSocket socket = serverSocketChannel.socket();

        socket.bind(addrees);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//        CharBuffer decode = Charset.defaultCharset().decode(byteBuffer);


        while(true){
            SocketChannel so = serverSocketChannel.accept();

            int readCount = 0;

            while (-1 != readCount){
                try {
                    readCount = so.read(byteBuffer);
                    System.out.println(new String(byteBuffer.array()));
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
                byteBuffer.rewind();
            }
        }

    }
}