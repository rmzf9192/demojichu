package com.el.jichu.designpattern.mediator;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 17:13
 * @Version:V1.0
 * @Description:Mediator User 类统一接口，User1 和 User2 分别是不同的对象，二者之间有关联，如果不采用中介 者模式，
 * 则需要二者相互持有引用，这样二者的耦合度很高，为了解耦，引入了 Mediator 类，提供统一接口，
 * MyMediator 为其实现类，里面持有 User1 和 User2 的实例，用来实现 对 User1 和 User2 的控制。
 * 这样 User1 和 User2 两个对象相互独立，他们只需要保持好和 Mediator 之间的关系就行，剩下的全由
 * MyMediator 类来维护！
 */
public interface Mediator {
    public void createMediator();

    public void workAll();
}
