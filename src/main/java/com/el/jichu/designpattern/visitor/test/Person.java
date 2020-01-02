package com.el.jichu.designpattern.visitor.test;

/**
 * @author roman zhangfei
 * @Date 2019/12/18 17:25
 * @Version V1.0
 */
public abstract class Person {
    //提供一个方法，让访问者可以访问
    public abstract void accept(Action action);
}