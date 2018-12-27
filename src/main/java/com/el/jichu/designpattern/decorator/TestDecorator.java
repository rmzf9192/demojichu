package com.el.jichu.designpattern.decorator;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/27 11:39
 * @Version:V1.0
 * @Description:TestDecorator:装饰模式测试
 * 装饰器模式的应用场景：
 *   1、需要扩展一个类的功能。
 *   2、动态的为一个对象增加功能，而且还能动态撤销。（继承不能做到这一点，继承的功能 是静态的，不能动态增删。）
 * 缺点：产生过多相似的对象，不易排错！
 */
public class TestDecorator {
    public static void main(String[] args) {
        Source source = new Source();
        Sourceable decorator = new Decorator(source);
        decorator.method1();
    }
}
