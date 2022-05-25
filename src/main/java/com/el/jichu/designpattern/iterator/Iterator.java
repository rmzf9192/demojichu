package com.el.jichu.designpattern.iterator;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 14:58
 * @Version:V1.0
 * @Description:Iterator
 */
public interface Iterator {

    //前移
    public Object previous();

    //后移
    Object next();

    boolean hasNext();

    //取得第一个元素
    Object first();
}
