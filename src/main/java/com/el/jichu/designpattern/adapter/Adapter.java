package com.el.jichu.designpattern.adapter;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/25 20:51
 * @Version:V1.0
 * @Description:Adapter：
 *
 *  适配器模式：
 *     核心思想：有一个类Source,拥有一个方法，待适配，目标接口是Targetable，通过Adapter类，
 *     将Source的功能扩展Targetable里，代码如下
 */
//类的适配器
public class Adapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is the targettable method2");
    }
}
