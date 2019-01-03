package com.el.jichu.designpattern.mediator;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 17:15
 * @Version:V1.0
 * @Description:User
 */
public abstract class User {
    private Mediator mediator;

    public User(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }
    public abstract void work();
}
