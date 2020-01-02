package com.el.jichu.io.netty.netty.dubborpc.publicinterface;

/**
 * @author roman zhangfei
 * @Date 2020/1/2 10:09
 * @Version V1.0
 */
//这是一个接口，是服务提供方和服务消费方都需要的
public interface HelloService {
    String hello(String msg);
}