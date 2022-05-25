package com.el.jichu.designpattern.simplefactory;

public class MailSender implements Sender {
    @Override
    public void sender() {
        System.out.println("发送邮件喽");
    }
}
