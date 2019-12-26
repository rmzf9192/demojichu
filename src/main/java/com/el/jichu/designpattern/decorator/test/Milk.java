package com.el.jichu.designpattern.decorator.test;

/**
 * @author roman zhangfei
 * @Date 2019/11/12 11:42
 * @Version V1.0
 */
public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        setDes(" 牛奶 ");
        setPrice(2.0f);
    }
}
