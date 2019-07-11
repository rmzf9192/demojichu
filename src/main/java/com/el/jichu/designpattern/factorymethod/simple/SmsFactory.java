package com.el.jichu.designpattern.factorymethod.simple;

/**
 * @author Roman.zhang
 * @Date: 2019/7/4 14:09
 * @Version:V1.0
 * @Description:SmsFactory
 */
public class SmsFactory  implements FactoryDao {
    @Override
    public Sender sender() {
        return new SmsSender();
    }
}
