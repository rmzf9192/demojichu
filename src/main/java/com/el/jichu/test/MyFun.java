package com.el.jichu.test;

public interface MyFun {

    default String getName() {
        return "哈哈哈，接口默认方法";
    }
}
