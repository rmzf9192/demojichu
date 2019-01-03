package com.el.jichu.designpattern.observer;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 14:31
 * @Version:V1.0
 * @Description:Observer2
 */
public class Observer2 implements Observer {
    @Override
    public void update() {
        System.out.println("observer has received");
    }
}
