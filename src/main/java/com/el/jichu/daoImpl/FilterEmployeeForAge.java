package com.el.jichu.daoImpl;

import com.el.jichu.dao.MyPredicate;
import com.el.jichu.domain.Employee;

public class FilterEmployeeForAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() > 30;
    }

    public static void test1(){
        System.out.println("jjjjjj");
    }
}
