package com.el.jichu.designpattern.visitor;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 17:00
 * @Version:V1.0
 * @Description:Subject Subject 类，accept 方法，接受将要访问它的对象，getSubject()获取将要被访问的属性
 */
public interface Subject {
    public void accept(Visitor visitor);

    public String getSubject();
}
