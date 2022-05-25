package com.el.jichu.designpattern.mediator.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 14:47
 * @Version:V1.0
 * @Description:Alarm
 */
public class Alarm extends Colleague {
    public Alarm(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name,this);
    }

    public void sendAlarm(int stateChange){
        sendMessage(stateChange);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange,this.name);
    }
}
