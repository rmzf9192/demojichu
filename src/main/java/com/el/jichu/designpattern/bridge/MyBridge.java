package com.el.jichu.designpattern.bridge;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/28 9:05
 * @Version:V1.0
 * @Description:MyBridge
 *  定义一个类，实现抽象类
 */
public class MyBridge extends Bridge {

    public void method(){
        getSourceable().method();
    }
}
