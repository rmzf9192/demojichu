package com.el.jichu.io.netty.netty.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author roman zhangfei
 * @Date 2019/12/31 16:58
 * @Version V1.0
 */
public class MyMessageDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyMessageDecoder decode 被调用");

        int count = in.readInt();

        byte[] bytes = new byte[count];

        in.readBytes(bytes);

        MessageProtocol protocol = new MessageProtocol();

        protocol.setContent(bytes);
        protocol.setLen(count);

        out.add(protocol);
    }
}