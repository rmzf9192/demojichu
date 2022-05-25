package com.el.jichu.designpattern.responsibilityofchain;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 15:45
 * @Version:V1.0
 * @Description:Test
 */
public class Test {
    public static void main(String[] args) {
        MyHandler h1 = new MyHandler("h1");
        MyHandler h2 = new MyHandler("h2");
        MyHandler h3 = new MyHandler("h3");
        h1.setHandler(h2);
        h2.setHandler(h3);
        h1.operator();
    }
}
