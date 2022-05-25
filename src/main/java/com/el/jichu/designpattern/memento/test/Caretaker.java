package com.el.jichu.designpattern.memento.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 14:25
 * @Version:V1.0
 * @Description:Caretaker
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
