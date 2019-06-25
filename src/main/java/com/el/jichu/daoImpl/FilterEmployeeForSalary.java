package com.el.jichu.daoImpl;

import com.el.jichu.dao.MyPredicate;
import com.el.jichu.domain.Employee;

public class FilterEmployeeForSalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() > 5000;
    }
}
