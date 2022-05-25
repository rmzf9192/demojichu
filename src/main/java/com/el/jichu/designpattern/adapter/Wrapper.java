package com.el.jichu.designpattern.adapter;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/25 21:23
 * @Version:V1.0
 * @Description:Wrapper:对象的适配器
 */

public class Wrapper implements Targetable {
    private Source source;

    public Wrapper(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the targettable method2");
    }
}
