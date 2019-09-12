package com.el.jichu.nio;

import lombok.val;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

/**
 * @Auther: Roman.zhang
 * @Date: 2018/12/1911:01
 * @Version:V1.0
 * @Description:TestBuffer 1.缓冲区（Buffer）,在java NIO中负责数据的存取，实际上就是数组，用来存储不同数据类型的数据
 * 根据数据类型不同（除boolean外），提供不同的相应类型的缓冲区
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 * 上述管理缓冲区的方式基本一致，通过allocate()获取缓冲区
 * 2.缓冲区获取数据两个核心的方法
 * put():存入数据到缓冲区
 * get():获取缓冲区中的数据
 * 3.缓冲区中的四个核心属性
 * capacity:容量，表示缓冲区中最大存储数据的数量，一旦设置不能改变。
 * limit:限制，表示缓冲区中可以操作的大小，（limt后数据不能进行读写）。
 * position:位置，表示缓冲区中正在操作数据的位置。
 * mark:标记，表示记录当前position的位置，可以通过reset回到mark的位置
 * 0 <= mark <= position <= limit <= capacity
 * 4.直接缓冲区与非直接缓冲区
 * 非直接缓冲区：通过allocate()分配缓冲区，将缓冲区建立在JVM中
 * 直接缓冲区：通过allocateDirect方法分配直接缓冲区，将缓冲区建立在物理内存中，可以提高效率
 */
public class TestBuffer {
    @Test
    public void test3() {
        //分配给直接缓冲区
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        System.out.println(buffer.isDirect());
        System.out.println("缓冲区容量：" + buffer.capacity());
        System.out.println("缓冲区限制：" + buffer.limit());
        System.out.println("缓冲区位置：" + buffer.position());
        System.out.println("缓冲区标记：" + buffer.mark());
    }

    @Test
    public void test2() {
        String str = "abcdefghijk";

        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        //切换读入数据模式
        buf.flip();

        byte[] bytes = new byte[buf.limit()];
        buf.get(bytes, 0, 2);
        System.out.println("标记前数据：" + new String(bytes, 0, 2));
        System.out.println("缓冲区所在位置：" + buf.position());

        //mark:标记
        buf.mark();
        buf.get(bytes, 2, 2);
        System.out.println("标记后数据：" + new String(bytes, 2, 2));
        System.out.println("缓冲区所在位置：" + buf.position());

        //reset:恢复到标记前的位置
        buf.reset();
        System.out.println("恢复到mark后的位置：" + buf.position());

        //判断缓冲区是否还有剩余数据
        if (buf.hasRemaining()) {
            //获取缓冲区中可以操做的数据数量
            System.out.println("缓冲区中可以操做的数据数量:" + buf.remaining());
        }
    }

    @Test
    public void test1() {
        String str = "abcde年后";
        //分配一个指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("====allocate===");
        System.out.println("缓冲区容量：" + byteBuffer.capacity());
        System.out.println("缓冲区限制：" + byteBuffer.limit());
        System.out.println("缓冲区位置：" + byteBuffer.position());
        System.out.println("缓冲区标记：" + byteBuffer.mark());

        //利用put把数据存到缓冲区中
        byteBuffer.put(str.getBytes());
        System.out.println("=====put=====");
        System.out.println("缓冲区容量：" + byteBuffer.capacity());
        System.out.println("缓冲区限制：" + byteBuffer.limit());
        System.out.println("缓冲区位置：" + byteBuffer.position());
        System.out.println("缓冲区标记：" + byteBuffer.mark());
        //3.切换到读入数据模式
        byteBuffer.flip();
        System.out.println("==========flip()===========");
        System.out.println("缓冲区容量：" + byteBuffer.capacity());
        System.out.println("缓冲区限制：" + byteBuffer.limit());
        System.out.println("缓冲区位置：" + byteBuffer.position());
        System.out.println("缓冲区标记：" + byteBuffer.mark());
        //4.利用get()读取数据
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
      /*  for (val b : bytes) {
            System.out.println("byte数组：" + b);
        }*/
        System.out.println(new String(bytes, 0, bytes.length));
        System.out.println("==========get()============");
        System.out.println("缓冲区容量：" + byteBuffer.capacity());
        System.out.println("缓冲区限制：" + byteBuffer.limit());
        System.out.println("缓冲区位置：" + byteBuffer.position());
        System.out.println("缓冲区标记：" + byteBuffer.mark());
        //5.可重复读
        byteBuffer.rewind();
        System.out.println("==========rewind()==============");
        System.out.println("缓冲区容量：" + byteBuffer.capacity());
        System.out.println("缓冲区限制：" + byteBuffer.limit());
        System.out.println("缓冲区位置：" + byteBuffer.position());
        System.out.println("缓冲区标记：" + byteBuffer.mark());

        //6.清空缓冲区：但是缓冲区的数据依然存在，但是处于“被遗忘”的状态
        byteBuffer.clear();
        System.out.println("==========clear()==============");
        System.out.println("缓冲区容量：" + byteBuffer.capacity());
        System.out.println("缓冲区限制：" + byteBuffer.limit());
        System.out.println("缓冲区位置：" + byteBuffer.position());
        System.out.println("缓冲区标记：" + byteBuffer.mark());

        //7.再次利用get()读取数据
        byte[] bytes1 = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes1);
       /* for (val b : bytes1) {
            System.out.println("byte数组：" + b);
        }*/
        System.out.println(new String(bytes1, 0, bytes1.length));
    }

    @Test
    public void test01() throws UnknownHostException {
        String jjj = String.format("%12s", "jjj");

        System.out.println(jjj.length());
        InetAddress inetAddress = InetAddress.getLocalHost();

        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());


    }

}
