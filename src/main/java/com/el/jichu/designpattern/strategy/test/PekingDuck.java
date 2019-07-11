package com.el.jichu.designpattern.strategy.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 10:03
 * @Version:V1.0
 * @Description:PekingDuck
 */
public class PekingDuck extends Duck {
    public PekingDuck() {
        flyBehavior = new BadFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("北京鸭");
    }
}
