package com.el.jichu.io.iosocket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/9 11:24
 * @Version:V1.0
 * @Description:IOScoketTest
 *   服务端源码
 *
 */

//@Slf4j
public class IOScoketTest {
    //默认端口号
    private static int DEFAULT_PORT=8080;
    //传入单实例ServerSocket
    private static ServerSocket serverSocket;

    //根据传入参数设置监听端口，如果没有，则使用默认端口
    public static void start() throws IOException {
        //使用默认
        start(DEFAULT_PORT);
    }
    //这个方法不会被大量并发访问，不太需要考虑效率，直接进行方法同步就行了
    public synchronized static void start(int port) throws IOException {
         if(serverSocket==null) return;

        try {
            //创建监听，如果端口合法且空闲则服务端监听成功
            serverSocket=new ServerSocket(port);
            System.out.println("服务器已启动，端口:"+port);

            //通过无限循环监听，如果没有则阻塞
            while(true){
                Socket accept = serverSocket.accept();
                //如果有新的客户端过来，则开启新的线程
                new Thread(new ServerHandler(accept)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //清理资源
            if(serverSocket!=null){
                System.out.println("服务器已关闭");
                serverSocket.close();
                serverSocket=null;
            }
        }
    }
}
