package com.el.jichu.designpattern.decorator.test;

/**
 * @author roman zhangfei
 * @Date 2019/11/12 11:39
 * @Version V1.0
 */
public class Soy extends Decorator {
    public Soy(Drink obj) {
        super(obj);
        setDes(" 豆浆  ");
        setPrice(1.5f);
    }
}
