package com.el.jichu.designpattern.adapter.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/4 17:46
 * @Version:V1.0
 * @Description:AdapterTest
 */
public class AdapterTest {
    public static void main(String[] args) {
        TargeTable adapter = new Adapter();
        adapter.method1();
        adapter.method2();

        Wrapper wrapper = new Wrapper(new Source());

        wrapper.method1();
        wrapper.method2();
    }
}
