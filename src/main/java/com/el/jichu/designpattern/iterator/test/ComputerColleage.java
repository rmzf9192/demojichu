package com.el.jichu.designpattern.iterator.test;

import java.util.Iterator;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 15:44
 * @Version:V1.0
 * @Description:ComputerColleage
 */
public class ComputerColleage implements College {
    Department[] departments;
    int numOfDepartment = 0;

    public ComputerColleage() {
        departments = new Department[5];
        addDepartment("Java专业", " Java专业 ");
        addDepartment("PHP专业", " PHP专业 ");
        addDepartment("大数据专业", " 大数据专业 ");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {

        Department department = new Department(name, desc);
        departments[numOfDepartment] = department;
        numOfDepartment+=1;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
