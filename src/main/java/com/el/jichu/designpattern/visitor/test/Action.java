package com.el.jichu.designpattern.visitor.test;

/**
 * @author roman zhangfei
 * @Date 2019/12/18 17:24
 * @Version V1.0
 */
public abstract class Action {
    //得到男性 的测评
    public abstract void getManResult(Man man);

    //得到女的 测评
    public abstract void getWomanResult(Woman woman);
}