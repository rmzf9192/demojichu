package com.el.jichu.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Auther: Roman.zhang
 * @Date: 2018/12/20 9:25
 * @Version:V1.0
 * @Description:TestBlockingNio 1.使用NIO网络通信的三个核心
 * 1.通道（Channel）：负责连接
 * java.nio.channels.Channel
 * |--SelectableChannel
 * |--SocketChannel
 * |--ServerSocketChannel
 * |--DatagramChannel
 * <p>
 * |--Pipe.SinkChannel
 * |--Pipe.SourceChannel
 * 2.缓冲区(Buffer) :负责数据的存储
 * 3.选择器(Selector):是SelectableChannel的多路复用器，用于监控SelectableChannel的IO状况
 * <p>
 * 注意：
 * 先执行服务端，一旦接收到客户端发送的数据，将会执行
 */
public class TestBlockingNio {
    //客户端 --本地服务-主要功能是，读取本地文件，并写到网络通信通道中
    @Test
    public void testClient() throws IOException {
        //获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("10.17.86.214", 9898));

        //获取读通道
        FileChannel inChannel = FileChannel.open(Paths.get("E:\\study\\aduc.zip"), StandardOpenOption.READ);

        //2.分配缓冲区大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //读取本地文件，并发送到服务端
        while (inChannel.read(byteBuffer) != -1) {
            //切换到读模式
            byteBuffer.flip();
            //写入到网络通道中
            socketChannel.write(byteBuffer);
            //清空缓存区
            byteBuffer.clear();
        }
        //关闭通道
        inChannel.close();
        socketChannel.close();

    }

    //服务端--接收客户端发送的数据，并写入到指定的路径中
    @Test
    public void testServer() throws IOException {
        //获取服务端通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        //创建写入的通道
        FileChannel outChannel = FileChannel.open(Paths.get("E:\\study\\1.zip"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        //根据 客户端端口号，获取连接
        ssChannel.bind(new InetSocketAddress(9898));
        //获取客户端的连接通道
        SocketChannel socketChannel = ssChannel.accept();

        //分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //读取客户端发送的数据，并写入到指定路径下
        while (socketChannel.read(byteBuffer) != -1) {
            //切换模式
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        //关闭通道
        socketChannel.close();
        outChannel.close();
        ssChannel.close();
    }
}
