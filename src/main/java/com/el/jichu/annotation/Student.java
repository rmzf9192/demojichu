package com.el.jichu.annotation;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/15 11:57
 * @Version:V1.0
 * @Description:Student
 */
@MyAnnotation
public class Student implements Person {
    private int count;
    @MyAnnotation(name = "小学生")//如果注解没有给定默认值，则必须在这里给name赋值
    @Override
    public void name() {

    }

    @MyAnnotation(say = "上课了")
    @Override
    public void say() {

    }


    @MyAnnotation
    @Override
    public void age() {

    }
}
