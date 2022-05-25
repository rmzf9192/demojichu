package com.el.jichu.designpattern.factorymethod;

import com.el.jichu.designpattern.simplefactory.Sender;

public class FactoryMethod {
    public static void main(String[] args) {
        Provider senderMailFactory = new SenderMailFactory();
        Sender produce = senderMailFactory.produce();
        produce.sender();
    }
}
