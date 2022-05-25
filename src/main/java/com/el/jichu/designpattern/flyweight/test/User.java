package com.el.jichu.designpattern.flyweight.test;

/**
 * @author roman zhangfei
 * @Date 2019/12/18 16:58
 * @Version V1.0
 */
public class User {
    private String name;

    public User(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}