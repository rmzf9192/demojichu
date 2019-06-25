package com.el.jichu.designpattern.proxy.aop;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/12 9:13
 * @Version:V1.0
 * @Description:ProxyHello
 *   静态代理：代理类
 */
public class ProxyHello implements IHello {
    private Hello hello;

    public   ProxyHello(Hello  hello){
        this.hello=hello;
    }
    @Override
    public void method() {
        Logger.start();
        hello.method();
        Logger.end();
    }


}
