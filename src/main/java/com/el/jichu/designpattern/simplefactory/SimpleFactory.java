package com.el.jichu.designpattern.simplefactory;

/**
 * 简单工厂模式
 */
public class SimpleFactory {
    /**
     * 一个方法
     *
     * @param type
     * @return
     */
    public Sender produce(String type) {
        if ("MailSender".equals(type)) {
            return new MailSender();
        } else if ("SmsSender".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型");
            return null;
        }
    }

    /**
     * 多个方法的工厂模式
     *
     * @return
     */
    public static Sender mailSender() {
        return new MailSender();
    }

    public static Sender smsSender() {
        return new SmsSender();
    }
}
