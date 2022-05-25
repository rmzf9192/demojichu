package com.el.jichu.designpattern.factorymethod.simple;

/**
 * @author Roman.zhang
 * @Date: 2019/7/4 13:51
 * @Version:V1.0
 * @Description:SenderFactory
 */
public class SenderFactory {
   /* public Sender creatSender(String sendType){
        if("sms".equals(sendType)){
            return new SmsSender();
        }else if ("mail".equals(sendType)){
            return new MailSender();
        }else {
            System.out.println("你的输入有误");
            return null;
        }
    }*/

    /**
     * 多个方法的方式
     * @param args
     */
    public static Sender createSmsSender(){
        return new SmsSender();
    }

    public static Sender createMailSender(){
        return new MailSender();
    }
    public static void main(String[] args) {
        /*SenderFactory senderFactory = new SenderFactory();
        Sender mailSender = senderFactory.createMailSender();
        mailSender.sender();*/
     /*   Sender sms = senderFactory.creatSender("sms");
        sms.sender();
        System.out.println(sms);*/
     // 静态工厂
        Sender mailSender = SenderFactory.createMailSender();
        mailSender.sender();
    }
}
