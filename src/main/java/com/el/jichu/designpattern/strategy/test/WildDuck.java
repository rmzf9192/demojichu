package com.el.jichu.designpattern.strategy.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 10:07
 * @Version:V1.0
 * @Description:WildDuck
 */
public class WildDuck extends Duck {
    public WildDuck() {
        flyBehavior = new GoodFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("这是野鸭");
    }
}
