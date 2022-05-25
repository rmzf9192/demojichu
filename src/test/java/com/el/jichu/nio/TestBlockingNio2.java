package com.el.jichu.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/20 14:34
 * @Version:V1.0
 * @Description:TestBlockingNio2 NIO 网络通信
 * ：增加用户反馈的功能
 */
public class TestBlockingNio2 {
    //客户端
    @Test
    public void client() throws IOException {
        //创建客户端通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        //创建读入通道
        FileChannel inChannel = FileChannel.open(Paths.get("E:\\study\\aduc.zip"), StandardOpenOption.READ);

        //创建缓存区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //读入文件，并发送到服务端
        while (inChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        socketChannel.shutdownOutput();

        //接收服务器端的反馈
        int len = 0;
        while ((len = socketChannel.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            System.out.println("接收服务端的反馈：" + new String(byteBuffer.array(), 0, len));
            byteBuffer.clear();
        }
        //关闭通道
        inChannel.close();
        socketChannel.close();
    }

    @Test
    public void clientTest() throws IOException {
       //创建客户端通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        //创建读入通道
        FileChannel inChannel = FileChannel.open(Paths.get("E:\\study\\aduc.zip"), StandardOpenOption.READ);

        //创建缓存区
        ByteBuffer allocate = ByteBuffer.allocate(1024);

        while(inChannel.read(allocate)!=-1){
            allocate.flip();
            socketChannel.write(allocate);
            allocate.clear();
        }

        socketChannel.shutdownOutput();

        //接收服务端的反馈
        int len=0;
        while((len=socketChannel.read(allocate))!=-1){
            allocate.flip();
            System.out.println("接收服务端的反馈："+new String(allocate.array(),0,len));
            allocate.clear();
        }

        //关闭通道
        inChannel.close();
        socketChannel.close();

    }
    //服务端
    @Test
    public void server() throws IOException {
        //获取服务端通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //创建写入文件通道
        FileChannel outChannel = FileChannel.open(Paths.get("E:\\study\\1.zip"), StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);

        //根据端口，绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9898));
        //获取连接客户端的通道
        SocketChannel socketChannel = serverSocketChannel.accept();

        //创建指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //接收客户端数据，保存到本地
        while (socketChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        //发送反馈给客户端
        byteBuffer.put("服务端接收信息成功".getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);

        //关闭通道
        socketChannel.close();
        outChannel.close();
        serverSocketChannel.close();
    }


    @Test
    public void testServer() throws IOException {
        //获取服务端通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //创建写入通道
        FileChannel outChannel = FileChannel.open(Paths.get("E:\\study\\2.zip"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //根据端口绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9898));
        //获取连接客户端的通道
        SocketChannel socketChannel = serverSocketChannel.accept();

        //创建指定大小的缓冲区
        ByteBuffer buffer=ByteBuffer.allocate(1024);

        //接收客户端数据，保存到本地
        while(socketChannel.read(buffer)!=-1){
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        //发送给客户端的反馈
        buffer.put("服务端接收数据成功".getBytes());
        buffer.flip();
        socketChannel.write(buffer);

        //关闭通道
        socketChannel.close();
        outChannel.close();
        serverSocketChannel.close();
    }
}
