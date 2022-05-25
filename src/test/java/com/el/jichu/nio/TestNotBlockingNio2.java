package com.el.jichu.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/20 17:35
 * @Version:V1.0
 * @Description:TestNotBlockingNio2
 */
public class TestNotBlockingNio2 {
    //发送
    @Test
    public void send() throws IOException {
        DatagramChannel dc = DatagramChannel.open();

        dc.configureBlocking(false);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String next = scanner.next();

            byteBuffer.put((new Date().toString() + "\n" + next).getBytes());
            byteBuffer.flip();
            dc.send(byteBuffer, new InetSocketAddress("127.0.0.1", 9898));
            byteBuffer.clear();
        }
        dc.close();
    }

    //接收
    @Test
    public void received() throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);

        datagramChannel.bind(new InetSocketAddress(9898));

        Selector selector = Selector.open();
        datagramChannel.register(selector, SelectionKey.OP_READ);

        while (selector.select() > 0) {
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                if (next.isReadable()) {
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    datagramChannel.receive(allocate);
                    allocate.flip();
                    System.out.println((new String(allocate.array(), 0, allocate.limit())));
                    allocate.clear();
                }
            }
            it.remove();
        }
    }

}
