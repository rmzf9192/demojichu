package com.el.jichu.io.netty.netty.dubborpc.provider;

import com.el.jichu.io.netty.netty.dubborpc.publicinterface.HelloService;

/**
 * @author roman zhangfei
 * @Date 2020/1/2 10:11
 * @Version V1.0
 */
public class HelloServiceImpl implements HelloService {
    private static int count = 0;
    //当消费者调用该方法时，就返回一个结果
    @Override
    public String hello(String msg) {
        System.out.println("收到客户端信息 = "+msg);
        if(null != msg){
            return "你好，客户端，我已经收到你的信息 [" + msg + "] 第" + (++count) + " 次";
        }else{
            return "你好客户端, 我已经收到你的消息 ";
        }
    }
}