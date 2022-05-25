package com.el.jichu.designpattern.memento;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 16:27
 * @Version:V1.0
 * @Description:Memento:是备忘录类
 */
public class Memento {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Memento(String value) {
        this.value = value;
    }
}
