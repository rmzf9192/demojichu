package com.el.jichu.designpattern.factorymethod.simple;

/**
 * @author Roman.zhang
 * @Date: 2019/7/4 14:11
 * @Version:V1.0
 * @Description:FactoryMethodTest
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        FactoryDao smsFactory = new SmsFactory();
        Sender sender = smsFactory.sender();

        sender.sender();
    }
}
