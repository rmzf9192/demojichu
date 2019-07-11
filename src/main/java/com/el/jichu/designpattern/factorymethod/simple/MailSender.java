package com.el.jichu.designpattern.factorymethod.simple;

/**
 * @author Roman.zhang
 * @Date: 2019/7/4 13:50
 * @Version:V1.0
 * @Description:MailSender
 */
public class MailSender implements Sender {
    @Override
    public void sender() {
        System.out.println("this is mail sender");
    }
}
