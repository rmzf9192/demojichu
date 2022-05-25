package com.el.jichu.designpattern.iterator.test;

import java.util.Iterator;
import java.util.List;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 15:42
 * @Version:V1.0
 * @Description:InfoColleageIterator
 */
public class InfoColleageIterator implements Iterator {
    List<Department> departmentList;
    int index = -1;

    public InfoColleageIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    //判断list中还有没有下一个元素
    @Override
    public boolean hasNext() {
        if(index >= departmentList.size() - 1) {
            return false;
        } else {
            index += 1;
            return true;
        }
    }

    @Override
    public Object next() {
        return departmentList.get(index);
    }

    //空实现remove
    public void remove() {

    }
}
