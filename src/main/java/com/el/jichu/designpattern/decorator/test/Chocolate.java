package com.el.jichu.designpattern.decorator.test;

/**
 * @author roman zhangfei
 * @Date 2019/11/12 11:36
 * @Version V1.0  具体的Decorator， 这里就是调味品
 */

public class Chocolate extends Decorator{
    public Chocolate(Drink obj) {
        super(obj);
        setDes(" 巧克力 ");
        setPrice(3.0f); // 调味品 的价格
    }
}
