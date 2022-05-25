package com.el.jichu.designpattern.observer;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 14:07
 * @Version:V1.0
 * @Description:MySubject
 */
public class MySubject extends AbstractSubject {
    @Override
    public void operate() {
        System.out.println("update self");
        notifyObservers();
    }
}
