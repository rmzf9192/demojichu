package com.el.jichu.designpattern.mediator;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 17:16
 * @Version:V1.0
 * @Description:User1
 */
public class User1 extends User {
    public User1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user1 exe");
    }
}
