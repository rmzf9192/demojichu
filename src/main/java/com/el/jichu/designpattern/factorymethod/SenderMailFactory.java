package com.el.jichu.designpattern.factorymethod;

import com.el.jichu.designpattern.simplefactory.MailSender;
import com.el.jichu.designpattern.simplefactory.Sender;

public class SenderMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
