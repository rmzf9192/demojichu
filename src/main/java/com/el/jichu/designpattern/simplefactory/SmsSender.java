package com.el.jichu.designpattern.simplefactory;

public class SmsSender implements Sender {
    @Override
    public void sender() {
        System.out.println("使用短信发送");
    }
}
