package com.el.jichu.designpattern.iterator;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 15:01
 * @Version:V1.0
 * @Description:Collection
 */
public interface Collection {

    Iterator iterator();

    //取得集合元素
    Object get(int i);

    //获取集合的大小
    int size();
}
