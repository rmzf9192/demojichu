package com.el.jichu.designpattern.strategy.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 9:48
 * @Version:V1.0
 * @Description:Duck
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public abstract void display();

    public void quack(){
        System.out.println("鸭子嘎嘎嘎叫");
    }

    public void swim(){
        System.out.println("鸭子在游泳");
    }

    public void fly(){
        if(flyBehavior!=null){
            flyBehavior.fly();
        }
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
