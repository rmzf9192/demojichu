package com.el.jichu.designpattern.decorator;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/27 11:33
 * @Version:V1.0
 * @Description:Decorator:装饰类 装饰模式：
 * 给一个对象增加一些新的功能，而且是动态的，要求装饰类与被装饰类实现同一接口，装饰对象持有被装饰对象的实例
 */
public class Decorator implements Sourceable {
    //创建被装饰类实现的接口
    private Sourceable sourceable;

    public Decorator(Sourceable sourceable) {
        this.sourceable = sourceable;
    }

    @Override
    public void method1() {
        System.out.println("before decorator ");
        sourceable.method1();
        System.out.println("after decorator ");
    }
}
