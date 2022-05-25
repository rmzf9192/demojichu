package com.el.jichu.designpattern.proxy.aop;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/12 19:20
 * @Version:V1.0
 * @Description:TestProxy
 */
public class TestProxy {
    public static void main(String[] args) {
//        IHello proxyHello = new ProxyHello(new Hello());
//        IHello proxyHello = (IHello) new DynaProxyHello().bind(new Hello());
        IHello proxyHello = (IHello) new DynaProxyLoggerHello().bind(new Hello(),new DynaLogger());
        proxyHello.method();

        Hello hello = new HelloImpl();

        hello.method();

    }
}
