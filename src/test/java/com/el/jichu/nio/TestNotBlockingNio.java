package com.el.jichu.nio;

import com.el.jichu.thread.transmit.Data;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/20 15:59
 * @Version:V1.0
 * @Description:TestNotBlockingNio
 *
 * 1.使用NIO网络通信的三个核心
 *   1.通道（Channel）：负责连接
 *      java.nio.channels.Channel
 *        |--SelectableChannel
 *          |--SocketChannel
 *          |--ServerSocketChannel
 *          |--DatagramChannel
 *
 *          |--Pipe.SinkChannel
 *          |--Pipe.SourceChannel
 *   2.缓冲区(Buffer) :负责数据的存储
 *   3.选择器(Selector):是SelectableChannel的多路复用器，用于监控SelectableChannel的IO状况
 *
 *   注意：
 *     先执行服务端，一旦接收到客户端发送的数据，将会执行
 */
public class TestNotBlockingNio {

    @Test
    public void client() throws IOException {
        //获取客户端通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        //设置为非阻塞
        socketChannel.configureBlocking(false);

        //分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //获得控制台输入的内容，并发送给服务端
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            String next = scanner.next();
            byteBuffer.put((new Date().toString()+"\n"+next).getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        socketChannel.close();
    }

    //服务端
    @Test
    public void server() throws IOException {
        //获取服务端通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9898));

        //获取选择器
        Selector selector = Selector.open();

        //将通道注册到选择器上，并指定“监听接收事件”
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //轮询式的获取选择器上已经是“准备就绪的事件”
        while(selector.select()>0){

            //获取当前选择器中所有注册的“选择键（已就绪的监听事件）”
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while(iterator.hasNext()){
                //获取已准备就绪的事件
                SelectionKey next = iterator.next();
                //判断是什么事件
                if(next.isAcceptable()){
                    //如果是接收准备就绪，获取客户端连接
                    SocketChannel accept = serverSocketChannel.accept();
                    //切换到非阻塞模式
                    accept.configureBlocking(false);
                    //将通道注册到选择器上
                    accept.register(selector, SelectionKey.OP_READ);

                }else if (next.isReadable()){
                    //获取当前通道上的读准备就绪的状态通道
                    SocketChannel channel = (SocketChannel) next.channel();

                    //创建缓冲区
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                    int len=0;
                    while((len=channel.read(byteBuffer))!=-1){
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(),0,len));
                        byteBuffer.clear();
                    }
                }
                //取消选择键
                iterator.remove();
            }
        }
    }

}
