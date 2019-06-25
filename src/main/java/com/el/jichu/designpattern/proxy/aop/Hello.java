package com.el.jichu.designpattern.proxy.aop;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/12 9:13
 * @Version:V1.0
 * @Description:Hello
 *   被代理类
 */
public class Hello implements IHello {
    @Override
    public void method() {
        System.out.println("this Hello method run......");
    }

    public static void me(){
        System.out.println("hhhh");
    }
}
