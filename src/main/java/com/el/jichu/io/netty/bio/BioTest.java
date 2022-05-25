package com.el.jichu.io.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author roman zhangfei
 * @Date 2019/12/27 15:40
 * @Version V1.0
 */
public class BioTest {
    public static void main(String[] args) throws IOException {
        short s = 12;

        ExecutorService threadPool = Executors.newCachedThreadPool();


        ServerSocket serverSocket = new ServerSocket(7070);

        System.out.println("服务端启动了");

        while (true){
            System.out.println("线程信息 id =" + Thread.currentThread().getId() + " 名字=" + Thread.currentThread().getName());
            //监听，等待客户端连接
            System.out.println("等待连接....");
            Socket accept = serverSocket.accept();

            System.out.println("连接到一个客户端");

            threadPool.execute(()->{handler(accept);});
        }
    }

    private static void handler(Socket accept) {
        try {
        System.out.println("线程信息 id =" + Thread.currentThread().getId() + " 名字=" + Thread.currentThread().getName());
        byte[] bytes = new byte[1024];

        InputStream inputStream = accept.getInputStream();

        while (true) {

            System.out.println("线程信息 id =" + Thread.currentThread().getId() + " 名字=" + Thread.currentThread().getName());

            System.out.println("read....");
            int read = inputStream.read(bytes);
            Thread.sleep(3000);
            if(-1 != read){
                System.out.println(new String(bytes, 0, read));
            }else{
                break;
            }
        }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("关闭和client的连接");
            try {
                accept.close();
            }catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}