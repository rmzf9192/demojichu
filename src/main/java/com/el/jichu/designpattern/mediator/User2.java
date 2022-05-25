package com.el.jichu.designpattern.mediator;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 17:17
 * @Version:V1.0
 * @Description:User2
 */
public class User2 extends User {
    public User2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user2 exe");
    }
}
