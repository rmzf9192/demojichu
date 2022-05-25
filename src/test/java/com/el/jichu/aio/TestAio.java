package com.el.jichu.aio;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author roman.zhang
 * @Date: 2019/9/12 9:14
 * @Version:V1.0
 * @Description:TestAio
 */
@Slf4j
public class TestAio {

    /**
     * 异步非阻塞 ：将来式
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test() throws IOException, ExecutionException, InterruptedException {
        log.info("jjj");
        Path path = Paths.get("E:\\study\\1.txt");
        Path path2 = Paths.get("E:\\study\\3.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path);
        AsynchronousFileChannel ouTchannel = AsynchronousFileChannel.open(path2,StandardOpenOption.CREATE,StandardOpenOption.WRITE);

        ByteBuffer buffer = ByteBuffer.allocate(10);

        if(buffer.hasRemaining()){
            Future<Integer> future = channel.read(buffer, 0);
            Integer integer = future.get();

            buffer.flip();
            CharBuffer decode = Charset.defaultCharset().decode(buffer);
            System.out.println("read length:"+integer);
            System.out.println(decode.toString());
            buffer.clear();
            Integer integer1 = channel.read(buffer, 0).get();
            while(channel.read(buffer,0).get()!=-1){
                buffer.flip();
//                CharBuffer decode1 = Charset.defaultCharset().decode(buffer);
                System.out.println(new String(buffer.array(),0,buffer.limit()));
                buffer.clear();
            }
        }


        Future<Integer> future = channel.read(buffer, 0);
       /* while(future.isDone()){
            buffer.flip();
            String str = new String(buffer.array(),0,buffer.limit());
            System.out.println(str);
            buffer.clear();
        }*/
        Integer integer = future.get();

      /*  while(channel.read(buffer, 0) !=null){
            buffer.flip();
            String str = new String(buffer.array(),0,buffer.limit());
            ouTchannel.write(buffer,buffer.limit());
            System.out.println(str);
            buffer.clear();
        }*/
        buffer.flip();

        CharBuffer charBuffer = CharBuffer.allocate(10);

        CharsetDecoder decoder = Charset.defaultCharset().newDecoder();

        decoder.decode(buffer,charBuffer,false);

        charBuffer.flip();

        String data = new String(charBuffer.array(),0,charBuffer.limit());

        System.out.println("read number: "+integer);

        System.out.println(data);
    }


    /**
     * 回调式
     */
    @Test
    public void test2() throws IOException, InterruptedException {
        Path path = Paths.get("E:\\study\\1.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path);

        ByteBuffer buffer = ByteBuffer.allocate(10);

        channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                attachment.flip();

                CharBuffer charBuffer = CharBuffer.allocate(10);
                CharsetDecoder decoder = Charset.defaultCharset().newDecoder();
                decoder.decode(attachment,charBuffer,true);
                System.out.println("data:"+new String(charBuffer.array(),0,charBuffer.limit()));
                System.out.println("内容大小："+result);
                System.out.println(new String(attachment.array(),0,attachment.limit()));
                System.out.println(Thread.currentThread().getName()+" success ");
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("error");
            }
        });

        while(true){
            System.out.println(Thread.currentThread().getName()+" sleep");

            Thread.sleep(3000);
        }
    }

    /**
     * 异步客户端
     */
    @Test
    public void testClient() throws ExecutionException, InterruptedException, IOException {
        AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
        channel.connect(new InetSocketAddress("127.0.0.1", 8888)).get();

        ByteBuffer byteBuffer = ByteBuffer.wrap("hell 你好啊".getBytes());

        Future<Integer> future = channel.write(byteBuffer);

        future.get();

        System.out.println("send success");
    }

    @Test
    public void testServer() throws IOException, InterruptedException {
        final AsynchronousServerSocketChannel channel = AsynchronousServerSocketChannel.open()
                .bind(new InetSocketAddress("127.0.0.1",8888));

        channel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(final AsynchronousSocketChannel client, Object attachment) {
                channel.accept(null,this);

                ByteBuffer buffer = ByteBuffer.allocate(1024);

                client.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        attachment.flip();

                        CharBuffer allocate = CharBuffer.allocate(1024);
                        CharsetDecoder decoder = Charset.defaultCharset().newDecoder();

                        decoder.decode(attachment,allocate,false);

                        allocate.flip();

                        String data = new String(allocate.array(),0,allocate.limit());

                        System.out.println("read data:"+data);

                        try {
                            client.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        System.out.println(" error  ");
                    }
                });
            }

            @Override
            public void failed(Throwable exc, Object attachment) {

            }
        });

        while(true){
            Thread.sleep(1000);
        }
    }

}
