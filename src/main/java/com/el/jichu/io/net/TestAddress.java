package com.el.jichu.io.net;

import lombok.val;

import java.net.*;

/**
 * @author roman zhangfei
 * @Date 2019/12/26 17:37
 * @Version V1.0
 */
public class TestAddress {
    public static void main(String[] args) throws UnknownHostException, MalformedURLException {
        InetAddress localHost = InetAddress.getLocalHost();

        System.out.println(localHost);
        System.out.println(localHost.getHostName());
        System.out.println(localHost.getHostAddress());
        System.out.println(localHost.getAddress());
        System.out.println(localHost.getCanonicalHostName());

        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);
        System.out.println(byName.getHostName());
        System.out.println(byName.getHostAddress());
        System.out.println(byName.getAddress());
        System.out.println(byName.getCanonicalHostName());


        InetSocketAddress inetSocketAddress = new InetSocketAddress(localHost.getHostName(), 8081);
        System.out.println(inetSocketAddress.getAddress());
        System.out.println(inetSocketAddress.getHostName());
        System.out.println(inetSocketAddress.getPort());
        System.out.println(inetSocketAddress.getHostString());

        System.out.println("=====================");

        URL url = new URL("https://bilibili.com");

        //获取此的授权部分 URL 。
        System.out.println(url.getAuthority());

        //获取此 URL的文件名。
        System.out.println(url.getFile());

        //获取端口
        System.out.println(url.getPort());

        //获取主机
        System.out.println(url.getHost());

        //获得默认端口
        System.out.println(url.getDefaultPort());

        //获得路径
        System.out.println(url.getPath());

        //获取该 URL的userInfo部分。
        System.out.println(url.getUserInfo());

        System.out.println("=====================");


    }
}