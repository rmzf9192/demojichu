package com.el.jichu.io.netty.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author roman zhangfei
 * @Date 2019/12/27 16:48
 * @Version V1.0
 */
public class MapperByteBufferTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("E:\\study\\4.txt", "rw");

        FileChannel channel = randomAccessFile.getChannel();

        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        map.put(0,(byte)'H');
        map.put(1,(byte)'H');
        map.put(2,(byte)'A');
        map.put(3,(byte)'D');
        map.put(4,(byte)'G');

        randomAccessFile.close();

        System.out.println("修改成功！！！");


    }
}