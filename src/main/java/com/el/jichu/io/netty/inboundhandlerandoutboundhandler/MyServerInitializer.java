package com.el.jichu.io.netty.inboundhandlerandoutboundhandler;

import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author roman zhangfei
 * @Date 2019/12/31 16:11
 * @Version V1.0
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //入站的handler进行解码 MyByteToLongDecoder
        //pipeline.addLast(new MyByteToLongDecoder());
        pipeline.addLast(new MyByteToLongDecoder2());
        // 出站handler编码
        pipeline.addLast(new MyByteToLongDecoder());

        pipeline.addLast(new MyServerHandler());

        System.out.println("xxx");
    }
}