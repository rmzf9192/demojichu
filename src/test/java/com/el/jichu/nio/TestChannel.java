package com.el.jichu.nio;

import lombok.val;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @Auther: Roman.zhang
 * @Date: 2018/12/19 15:29
 * @Version:V1.0
 * @Description:TestChannel 1.通道（Channel）:用于源节点与目的节点的连接。在java nio中，负责缓冲区数据的传输，channel本身不存储数据，
 * 需要缓冲区去配合进行传输。
 * 2.通道的主要实现类
 * java.nio.channels.Channel
 * |--FileChannel
 * |--SocketChannel
 * |--ServerSocketChannel
 * |--DatagramChannel
 * 3.获取通道
 * 1.java针对支持的通道类提供了getChannel()方法
 * 本地IO:
 * FileInputStream/FileOutputStream
 * RandomAccessFile
 * 网络IO
 * Socket
 * ServerSocket
 * DatagramScoket
 * 2. 在 JDK 1.7 中的 NIO.2 针对各个通道提供了静态方法 open()
 * 3. 在 JDK 1.7 中的 NIO.2 的 Files 工具类的 newByteChannel()
 * 4.通道之间的数据传输
 * transferFrom()
 * transferTo()
 * 5.分散（Scatter）与聚集（Gather）
 * 分散读取（Scatter Reads）：将通道中的数据分散到多个缓冲区中
 * 聚集写入（Gather Writes）：将多个缓冲区中的数据聚集到通道中
 * 6.字符集
 * 编码：字符串-》字节数组
 * 解码：字节数组-》字符串
 */
public class TestChannel {
    @Test
    public void test6() throws CharacterCodingException {
        Charset gbk1 = Charset.forName("GBK");

        //获取字符集编码器
        CharsetEncoder ce = gbk1.newEncoder();
        //获取字符集解码器
        CharsetDecoder cd = gbk1.newDecoder();

        //创建缓存区
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("站的有点高啊！");
        charBuffer.flip();

        //编码
        ByteBuffer encode = ce.encode(charBuffer);
        for (int i = 0; i < 12; i++) {
            System.out.println("编码后的内容：" + encode.get());
        }

        //解码
        encode.flip();
        CharBuffer cb = cd.decode(encode);
        System.out.println("解码后的内容：" + cb.toString());

        System.out.println("========================================");

        Charset gbk = Charset.forName("GBK");

        encode.flip();
        CharBuffer decode = gbk.decode(encode);
        System.out.println("再次解码后的内容:" + decode.toString());
    }

    @Test
    public void test5() {
        Map<String, Charset> charsetSortedMap = Charset.availableCharsets();
        Set<Entry<String, Charset>> entrySet = charsetSortedMap.entrySet();
        for (val v : entrySet) {
            System.out.println(v.getKey() + "=" + v.getValue());
        }
    }

    //分散聚集
    @Test
    public void test4() throws IOException {
        RandomAccessFile rdf = new RandomAccessFile("E:\\study\\1.txt", "rw");

        //获取通道
        FileChannel inChannel = rdf.getChannel();

        //分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(1);
        ByteBuffer buf2 = ByteBuffer.allocate(10);

        // 分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        inChannel.read(bufs);

        //切换模式
        for (val buffer : bufs) {
            buffer.flip();
        }

        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println("+==================================+");
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

        //聚集写入
        RandomAccessFile outChannel = new RandomAccessFile("E:\\study\\2.txt", "rw");

        FileChannel channel = outChannel.getChannel();
        channel.write(bufs);

    }

    //通道之间数据的传输（直接缓存）
    @Test
    public void test3() {
        long start = System.currentTimeMillis();
        try {
            FileChannel inChannel = FileChannel.open(Paths.get("E:\\study\\aduc.zip"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("E:\\study\\1.zip"), StandardOpenOption.WRITE,
                    StandardOpenOption.READ, StandardOpenOption.CREATE);
            //outChannel.transferFrom(inChannel, 0, inChannel.size());
            inChannel.transferTo(0,inChannel.size(),outChannel);
            outChannel.close();
            inChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

        long end = System.currentTimeMillis();
        System.out.println("耗费的时间：" + (end - start));


    }

    //使用直接缓冲区，完成文件复制（内存映射文件）
    @Test
    public void test2() throws IOException {
        long start = System.currentTimeMillis();

        FileChannel inChannel = FileChannel.open(Paths.get("E:\\study\\aduc.zip"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("E:\\study\\1.zip"), StandardOpenOption.READ,
                StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //内存映射文件
        MappedByteBuffer inMappBuffer = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMapBuffer = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());

        //直接对缓冲区进行数据的读写
        byte[] bytes = new byte[inMappBuffer.limit()];
        inMappBuffer.get(bytes);
        outMapBuffer.put(bytes);

        inChannel.close();
        outChannel.close();

        long end = System.currentTimeMillis();

        System.out.println("耗费的时间：" + (end - start));

    }

    //利用通道完成文件的复制（非直接缓冲区）
    @Test
    public void test1() {
        long l = System.currentTimeMillis();
        try (
                //创建输入输出流
//                FileInputStream fis = new FileInputStream("E:\\study\\aduc.zip");
                FileInputStream fis = new FileInputStream("E:\\study\\1.txt");
                FileOutputStream fos = new FileOutputStream("E:\\study\\1.zip");
                //创建通道
                FileChannel inChannel = fis.getChannel();
                FileChannel outChannel = fos.getChannel())
        {

            //创建指定大小的缓冲区
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            //将通道中的数据读入到缓冲区中
            while (inChannel.read(allocate) != -1) {
                //切换到读取数据模式
                allocate.flip();
                //将缓冲区的数据写入通道中。
                outChannel.write(allocate);
                System.out.println(new String(allocate.array(),0,allocate.limit()));
                //清空缓冲区
                allocate.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }/*finally {
            if(outChannel!=null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inChannel!=null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/
        long l1 = System.currentTimeMillis();

        System.out.println("执行的时间是：" + (l1 - l));
    }


}
