package com.el.jichu.designpattern.observer;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 14:33
 * @Version:V1.0
 * @Description:Subject
 */
public interface Subject {
    //增加观察者
    public void add(Observer observer);

    //删除观察这
    public void del(Observer observer);

    //通知所有观察者
    public void notifyObservers();

    //自身的操作
    public void operate();
}
