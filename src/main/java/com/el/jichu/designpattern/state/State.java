package com.el.jichu.designpattern.state;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 16:40
 * @Version:V1.0
 * @Description:State State 类是个状态类，Context 类可以实现切换
 */
public class State {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void method1() {
        System.out.println("execute the first opt1");
    }

    public void method2() {
        System.out.println("execute the second opt2");
    }
}
