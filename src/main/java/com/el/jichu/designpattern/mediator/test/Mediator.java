package com.el.jichu.designpattern.mediator.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 14:43
 * @Version:V1.0
 * @Description:Mediator
 */
public abstract class Mediator {

    public abstract void register(String colleagueName, Colleague colleague);

    public abstract void getMessage(int stateChange,String colleagueName);

    public abstract void sendMessage();
}
