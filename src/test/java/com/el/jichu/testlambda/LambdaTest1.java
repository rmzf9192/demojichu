package com.el.jichu.testlambda;

import com.el.jichu.dao.MyPredicate;
import com.el.jichu.daoImpl.FilterEmployeeForAge;
import com.el.jichu.daoImpl.FilterEmployeeForSalary;
import com.el.jichu.domain.Employee;
import org.junit.Test;

import java.util.*;

public class LambdaTest1 {

    @Test
    public void test1(){
        //无参数，无返回值
        Runnable runnable = () -> System.out.println("hello");
        runnable.run();
    }


    //使用匿名函数
    @Test
    public void test() {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer i = Integer.compare(o1.length(), o2.length());
                return i;
            }
        };
        TreeSet<String> treeSet = new TreeSet<>(comparator);
        System.out.println(treeSet.comparator().compare("jjjj", "pppp"));

        System.out.println(comparator.compare("hasd", "jjsha") + ",," + treeSet);
        TreeSet<String> treeSet1 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer i = Integer.compare(o1.length(), o2.length());
                return i;
            }
        });
        System.out.println(treeSet1.comparator().compare("ssss", "dfa"));
    }

    //现在的lambda语法
    @Test
    public void test2() {
        Comparator<String> comparator = (x, y) -> Integer.compare(x.length(), y.length());
        TreeSet<String> treeSet = new TreeSet<>(comparator);
        System.out.println(treeSet.comparator().compare("jjj", "kk"));
    }

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    //需求:获取年龄大于30岁的员工
    public List<Employee> getEmpsByAge(List<Employee> list) {
        List<Employee> empList = new ArrayList<>();

        for (Employee employee : list) {
            if (employee.getAge() > 30) {
                empList.add(employee);
            }
        }
        return empList;
    }

    @Test
    public void test3() {
        List<Employee> empsByAge = this.getEmpsByAge(emps);
        for (Employee e : empsByAge) {
            System.out.println(e);
        }
    }

    //需求：获取工资大于5000的员工
    public List<Employee> getEmpsBySalary(List<Employee> list) {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getSalary() > 5000) {
                employees.add(employee);
            }
        }
        return employees;
    }

    @Test
    public void Test4() {
        List<Employee> empsBySalary = getEmpsBySalary(emps);

        for (Employee employee : empsBySalary) {
            System.out.println(employee);
        }

    }

    //优化方式一：策略设计模式
    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {
        List<Employee> employeeList = new ArrayList<>();

        for (Employee employee : list) {
            if (mp.test(employee)) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    @Test
    public void test5() {
        List<Employee> employees = filterEmployee(emps, new FilterEmployeeForAge());

        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("===============================================");

        List<Employee> employees1 = filterEmployee(emps, new FilterEmployeeForSalary());

        for (Employee employee : employees1) {
            System.out.println(employee);
        }

    }

    //优化方式二：匿名内部类
    @Test
    public void test6() {
        List<Employee> lists = filterEmployee(emps, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() > 5000;
            }
        });
        for (Employee employee : lists) {
            System.out.println(employee);
        }
    }

    //优化方式三：lambda语法
    @Test
    public void test7() {
        //lambda：方法引用
        List<Employee> lists = filterEmployee(emps, (e) -> e.getAge() > 30);
        lists.forEach(System.out::println);
        System.out.println("-------------------------------");
        //lambda:正常形式
        List<Employee> list = filterEmployee(emps, (employee -> employee.getAge() > 30));
        list.forEach((e) -> System.out.println(e));
    }

    //优化四：Stream API
    @Test
    public void test8() {
        emps.stream()
                .filter((e) -> e.getAge() > 35)
                .forEach(System.out::println);
        System.out.println("---------------------------");

        emps.stream()
                .map(Employee::getSalary)
                .limit(3)
                .forEach(System.out::println);
        System.out.println("---------------------------");
        emps.stream().distinct();
    }

}
