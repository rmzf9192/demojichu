package com.el.jichu.designpattern.observer;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 14:16
 * @Version:V1.0
 * @Description:Observer1
 */
public class Observer1 implements Observer {
    @Override
    public void update() {
        System.out.println("observers has received");
    }
}
