package com.el.jichu.dao;

public interface JDK8Interface {

    static void staticMethod() {
        System.out.println("接口的静态方法");
    }

    default void defaultMethod() {
        System.out.println("接口中的默认方法");
    }

}
