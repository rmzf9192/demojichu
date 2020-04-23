package com.el.jichu.test;

public interface MyInterface {

    default String getName() {
        return "呵呵呵,接口默认方法";
    }

    public static void show() {
        System.out.println("接口中的静态方法");
    }
}
