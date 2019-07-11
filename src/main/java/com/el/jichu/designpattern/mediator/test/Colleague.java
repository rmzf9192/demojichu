package com.el.jichu.designpattern.mediator.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 14:45
 * @Version:V1.0
 * @Description:Colleague
 */
public abstract class Colleague {
    private Mediator mediator;

    public String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public Mediator getMediator(){
        return this.mediator;
    }

    public abstract void sendMessage(int stateChange);
}
