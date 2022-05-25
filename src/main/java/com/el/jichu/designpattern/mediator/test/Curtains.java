package com.el.jichu.designpattern.mediator.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 14:55
 * @Version:V1.0
 * @Description:Curtains
 */
public class Curtains extends Colleague {
    public Curtains(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name,this);
    }

    public void upCurtains(){
        System.out.println(" I am holding curtains");
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange,this.name);
    }
}
