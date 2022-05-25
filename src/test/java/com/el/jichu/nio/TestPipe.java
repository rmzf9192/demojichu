package com.el.jichu.nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/20 19:59
 * @Version:V1.0
 * @Description:TestPipe
 */
public class TestPipe {

    @Test
    public void test() throws IOException {
        //获取通道
        Pipe open = Pipe.open();

        //创建缓存区，并写入通道中

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        Pipe.SinkChannel sinkChannel = open.sink();
        byteBuffer.put("同道中的数据".getBytes());
        byteBuffer.flip();
        sinkChannel.write(byteBuffer);

        //读取通道中的数据
        Pipe.SourceChannel source = open.source();

        byteBuffer.flip();
        int read = source.read(byteBuffer);

        System.out.println(new String(byteBuffer.array(), 0, read));

        source.close();
        sinkChannel.close();
    }
}
