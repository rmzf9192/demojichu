package com.el.jichu.designpattern.mediator.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 14:52
 * @Version:V1.0
 * @Description:CoffeeMachine
 */
public class CoffeeMachine extends Colleague {
    public CoffeeMachine(Mediator mediator, String name) {

        super(mediator, name);
        mediator.register(name,this);
    }

    public void startCoffee(){
        System.out.println("it's time to startcoffee");
    }
    public void finishCoffee(){
        System.out.println("after 5 minutes!");
        System.out.println("coffee is ok");
        sendMessage(0);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange,this.name);
    }
}
