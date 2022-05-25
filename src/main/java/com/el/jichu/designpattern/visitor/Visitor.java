package com.el.jichu.designpattern.visitor;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 16:55
 * @Version:V1.0
 * @Description:Visitor:存放要访问的对象
 */
public interface Visitor {
    public void visit(Subject subject);
}
