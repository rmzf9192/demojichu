package com.el.jichu.designpattern.iterator.test;

import java.util.Iterator;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 15:43
 * @Version:V1.0
 * @Description:College
 */
public interface College {
    public String getName();

    //增加系的方法
    public void addDepartment(String name, String desc);

    //返回一个迭代器,遍历
    public Iterator createIterator();
}
