package com.el.jichu.designpattern.simplefactory;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
      /*  //测试单个方法的工厂模式
        Sender smsSender = simpleFactory.produce("MailSender");
        smsSender.sender();*/
      /*  Sender sender = simpleFactory.smsSender();
        sender.sender();
        Sender sender1 = simpleFactory.mailSender();
        sender1.sender();*/
        //静态方法
        Sender sender = SimpleFactory.mailSender();
        sender.sender();
    }
}
