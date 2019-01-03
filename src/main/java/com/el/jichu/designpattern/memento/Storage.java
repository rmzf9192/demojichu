package com.el.jichu.designpattern.memento;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 16:31
 * @Version:V1.0
 * @Description:Storage 存储备忘录的类
 */
public class Storage {
    private Memento memento;

    public Storage(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

}
