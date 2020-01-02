package com.el.jichu.io.netty.netty.dubborpc.provider;


import com.el.jichu.io.netty.netty.dubborpc.netty.NettyServer;

/**
 * @author roman zhangfei
 * @Date 2020/1/2 10:17
 * @Version V1.0
 */
//ServerBootstrap 会启动一个服务提供者，就是NettyServer
public class ServerBootstrap {
    public static void main(String[] args) {
        NettyServer.startServer("127.0.0.1",7000);
    }
}