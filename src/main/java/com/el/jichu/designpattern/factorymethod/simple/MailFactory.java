package com.el.jichu.designpattern.factorymethod.simple;

/**
 * @author Roman.zhang
 * @Date: 2019/7/4 14:10
 * @Version:V1.0
 * @Description:MailFactory
 */
public class MailFactory implements FactoryDao {
    @Override
    public Sender sender() {
        return new MailSender();
    }
}
