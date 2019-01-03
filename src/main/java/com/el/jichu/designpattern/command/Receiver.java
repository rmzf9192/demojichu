package com.el.jichu.designpattern.command;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 16:09
 * @Version:V1.0
 * @Description:Receiver:被调用者（士兵）
 */
public class Receiver {
    public void action(){
        System.out.println("command received!");
    }
}
