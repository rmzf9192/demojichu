package com.el.jichu.io.netty.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author roman zhangfei
 * @Date 2019/12/30 15:18
 * @Version V1.0
 */
public class NettyServer {

    public static void main(String[] args) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //创建服务端的启动对象，配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();
            //使用链式编程来进行设置
            bootstrap.group(bossGroup,workerGroup)//设置两个线程组
            .channel(NioServerSocketChannel.class)//使用NioSocketChannel作为服务器的通道实现
            .option(ChannelOption.SO_BACKLOG,128)//设置线程队列得到连接个数
            .childOption(ChannelOption.SO_KEEPALIVE,true)//设置保持活动连接数
            .childHandler(new ChannelInitializer<SocketChannel>() {
                //创建一个通道连接测试对象
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    System.out.println("客户socketChannel hascode = "+socketChannel.hashCode());
                    socketChannel.pipeline().addLast(new NettyServerHandler());
                }
            });

            System.out.println("服务端 is ready ...");
            //启动服务器
            ChannelFuture cf = bootstrap.bind(6668).sync();

            //注册关心的事件
            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if(channelFuture.isSuccess()){
                        System.out.println("监听端口 6668 成功");
                    } else {
                        System.out.println("监听端口 6668 失败");
                    }
                }
            });

            //对关闭通道进行监听
            cf.channel().closeFuture().sync();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}