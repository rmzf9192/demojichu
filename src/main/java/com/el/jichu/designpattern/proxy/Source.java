package com.el.jichu.designpattern.proxy;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/27 14:23
 * @Version:V1.0
 * @Description:Source
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is the source method");
    }
}
