package com.el.jichu.designpattern.adapter.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/5 11:44
 * @Version:V1.0
 * @Description:Test
 */
public class Test {
    public static void main(String[] args) {
        Sourceable1 sourceable1 = new Sourceable1();
        Sourceable2 sourceable2 = new Sourceable2();

        sourceable1.method1();
        sourceable1.method2();

        sourceable2.method2();
        sourceable2.method1();
    }
}
