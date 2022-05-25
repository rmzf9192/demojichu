package com.el.jichu.designpattern.factorymethod;

import com.el.jichu.designpattern.simplefactory.Sender;
import com.el.jichu.designpattern.simplefactory.SmsSender;

public class SenderSmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
