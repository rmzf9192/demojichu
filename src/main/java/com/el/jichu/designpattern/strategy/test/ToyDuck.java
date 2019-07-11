package com.el.jichu.designpattern.strategy.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 10:04
 * @Version:V1.0
 * @Description:ToyDuck
 */
public class ToyDuck extends Duck {
    public ToyDuck() {
        flyBehavior = new NoFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("玩具鸭");
    }
    @Override
    public void quack(){
        System.out.println("玩具鸭不能叫");
    }

    @Override
    public void swim(){
        System.out.println("玩具鸭不能游泳");
    }
}
