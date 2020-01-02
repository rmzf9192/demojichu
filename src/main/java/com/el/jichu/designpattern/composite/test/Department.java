package com.el.jichu.designpattern.composite.test;

/**
 * @author roman zhangfei
 * @Date 2019/12/18 16:38
 * @Version V1.0
 */
public class Department extends OrganizationComponent {
    //没有集合

    public Department(String name, String des) {
        super(name, des);
    }


    //add , remove 就不用写了，因为他是叶子节点

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    protected void print() {
        System.out.println(getName());
    }
}