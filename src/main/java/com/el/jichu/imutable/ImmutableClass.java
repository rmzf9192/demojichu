package com.el.jichu.imutable;

import java.util.Date;

/**
 * @author Roman.Zhang
 * @date 2020/4/17
 * @description:
 *  注意实例的变量本身可能是不可变的，也可能是可变的
 * 对于所有可变的成员变量，返回时需要复制一份新的
 * 不可变的成员变量不用做特殊处理
 */
public class ImmutableClass {
    /**
     * Integer类是不可变的，因为它没有提供任何setter方法来改变值
     * */
    private final Integer immutableField1;
    /**
     * String类是不可变的，它也没有提供任何setter方法来改变值
     * */
    private final String immutableField2;
    /**
     * Date类是可变的，它提供了改变日期或时间的setter方法
     * */
    private final Date mutableField;

    // 将构造方法声明为private，确保不会有意外情况构造这个类
    private ImmutableClass(Integer fld1, String fld2, Date date)
    {
        this.immutableField1 = fld1;
        this.immutableField2 = fld2;
        this.mutableField = new Date(date.getTime());
    }

    // 工厂方法将创建对象的逻辑封装在一个地方
    public static ImmutableClass createNewInstance(Integer fld1, String fld2, Date date)
    {
        return new ImmutableClass(fld1, fld2, date);
    }

    // 不提供setter方法

    /**
     * Integer类是不可变的，可以直接返回成员变量的实例
     * */
    public Integer getImmutableField1() {
        return immutableField1;
    }

    /**
     * String类是不可变的，可以直接返回成员变量的实例
     * */
    public String getImmutableField2() {
        return immutableField2;
    }

    /**
     * Date类是可变的，需要注意一下
     * 不要返回原始成员变量的引用
     * 创建一个新的Date对象，内容和成员变量一样
     * */
    public Date getMutableField() {
        return new Date(mutableField.getTime());
    }

    @Override
    public String toString() {
        return immutableField1 +" - "+ immutableField2 +" - "+ mutableField;
    }
}
