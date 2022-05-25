package com.el.jichu.designpattern.memento;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 16:25
 * @Version:V1.0
 * @Description:Original Original 类是原始类，里面有需要保存的属性 value 及创建一个备忘录类，用来保存 value 值。Memento 类是备忘录类，
 * Storage 类是存储备忘录的类，持有 Memento 类的实例，该 模式很好理解。
 */
public class Original {

    private String value;

    public Original(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Memento createMemento() {
        return new Memento(value);
    }

    public void restoreMemento(Memento me) {
        this.value = me.getValue();
    }
}
