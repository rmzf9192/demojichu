package com.el.jichu.designpattern.mediator;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 17:20
 * @Version:V1.0
 * @Description:TestMediator
 */
public class TestMediator {
    public static void main(String[] args) {
        MyMediator myMediator = new MyMediator();
        myMediator.createMediator();
        myMediator.workAll();
    }
}
