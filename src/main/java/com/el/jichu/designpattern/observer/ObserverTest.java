package com.el.jichu.designpattern.observer;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 14:51
 * @Version:V1.0
 * @Description:ObserverTest
 */
public class ObserverTest {
    public static void main(String[] args) {
        MySubject mySubject = new MySubject();
        mySubject.add(new Observer1());
        mySubject.add(new Observer2());
        mySubject.operate();
    }
}
