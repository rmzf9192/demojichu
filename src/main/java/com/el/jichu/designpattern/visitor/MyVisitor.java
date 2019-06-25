package com.el.jichu.designpattern.visitor;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 17:02
 * @Version:V1.0
 * @Description:MyVisitor
 */
public class MyVisitor implements Visitor {
    @Override
    public void visit(Subject subject) {
        System.out.println("visit the subject :" + subject.getSubject());
    }
}
