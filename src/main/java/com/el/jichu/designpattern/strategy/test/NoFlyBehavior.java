package com.el.jichu.designpattern.strategy.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 9:55
 * @Version:V1.0
 * @Description:NoFlyBehavior
 */
public class NoFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞翔技术");
    }
}
