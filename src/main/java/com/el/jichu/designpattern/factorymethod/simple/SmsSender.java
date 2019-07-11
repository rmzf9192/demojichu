package com.el.jichu.designpattern.factorymethod.simple;

/**
 * @author Roman.zhang
 * @Date: 2019/7/4 13:49
 * @Version:V1.0
 * @Description:SmsSender
 */
public class SmsSender implements Sender {
    @Override
    public void sender() {
        System.out.println("this is sms sender ");
    }
}
