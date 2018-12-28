package com.el.jichu.designpattern.proxy;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/27 17:49
 * @Version:V1.0
 * @Description:Proxy：代理类
 */
public class Proxy implements Sourceable {
    private Source source;

    public Proxy() {
        this.source = new Source();
    }

    @Override
    public void method() {
        before();
        source.method();
        after();
    }
    private void before(){
        System.out.println("before proxy");
    }
    private void after(){
        System.out.println("after proxy");
    }
}
