package com.el.jichu.designpattern.adapter.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/4 17:59
 * @Version:V1.0
 * @Description:Wrapper
 */
public class Wrapper implements TargeTable {
    private Source source;

    public Wrapper(Source source){
        this.source= source;
    }
    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is running Wrapper method2");
    }
}
