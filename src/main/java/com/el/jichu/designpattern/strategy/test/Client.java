package com.el.jichu.designpattern.strategy.test;

import java.util.concurrent.TimeUnit;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 10:08
 * @Version:V1.0
 * @Description:Client
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        WildDuck wildDuck = new WildDuck();
        wildDuck.fly();

        ToyDuck toyDuck = new ToyDuck();
        toyDuck.fly();

        PekingDuck pekingDuck = new PekingDuck();
        pekingDuck.fly();

        pekingDuck.setFlyBehavior(new NoFlyBehavior());
        System.out.println("北京鸭的实际飞翔能力");
        pekingDuck.fly();
        TimeUnit.SECONDS.sleep(1000);
    }
}
