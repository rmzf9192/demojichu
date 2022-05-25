package com.el.jichu.designpattern.visitor;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 17:03
 * @Version:V1.0
 * @Description:MySubject
 */
public class MySubject implements Subject {
    @Override
    public void accept(Visitor visitor) {
        System.out.println("this;" + this);
        visitor.visit(this);
    }

    @Override
    public String getSubject() {
        return "love";
    }
}
