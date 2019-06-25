package com.el.jichu.designpattern.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 14:37
 * @Version:V1.0
 * @Description:AbstractSubject
 */
public abstract class AbstractSubject implements Subject {
    private Vector<Observer> observers = new Vector<>();

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void del(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> elements = observers.elements();
        while (elements.hasMoreElements()) {
            elements.nextElement().update();
        }
    }
}
