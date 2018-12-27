package com.el.jichu.designpattern.decorator;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/27 11:34
 * @Version:V1.0
 * @Description:Source :被装饰类
 */
public class Source implements Sourceable {
    /*
    被装饰类原有功能
     */
    @Override
    public void method1() {
        System.out.println("this is original method!");
    }
}
