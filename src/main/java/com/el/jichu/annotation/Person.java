package com.el.jichu.annotation;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/15 11:55
 * @Version:V1.0
 * @Description:Person
 */
@MyAnnotation
public interface Person {
    @MyAnnotation
    public void name();
    @MyAnnotation
    public void say();
    @MyAnnotation
    public void age();
}
