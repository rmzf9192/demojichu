package com.el.jichu.designpattern.adapter.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/4 17:44
 * @Version:V1.0
 * @Description:Adapter
 */
public class Adapter extends Source implements TargeTable {
    @Override
    public void method2() {
        System.out.println("Adapter is running method2");
    }
}
