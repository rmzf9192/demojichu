package com.el.jichu.designpattern.iterator.test;

import java.util.Iterator;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 15:37
 * @Version:V1.0
 * @Description:ComputerCollegeIterator
 */
public class ComputerCollegeIterator implements Iterator {
    Department[] departments;
    int position = 0;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if(position>=departments.length||departments[position]==null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Object next() {
        Department department = departments[position];
        position+=1;
        return department;
    }

}
