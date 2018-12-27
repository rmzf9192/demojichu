package com.el.jichu.testlambda;

import com.el.jichu.dao.MyFunction;
import com.el.jichu.dao.MyFunction2;
import com.el.jichu.domain.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda {

    List<Employee> emps= Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 18, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
            );

    @Test
    public void test1(){
        Collections.sort(emps,(e1,e2)->{
            if(e1.getAge()==e2.getAge()){
                int returnValue=e1.getName().compareTo(e2.getName());
                return returnValue;
            }else{
                int i=-Integer.compare(e1.getAge(),e2.getAge());
                return i;
            }
        });
        for(Employee employee:emps){
            System.out.println("id:"+employee.getId()+",姓名:"+employee.getName()+",年龄:"+employee.getAge()+",薪水:"+employee.getSalary());
        }
    }

    @Test
    public void test2(){
        String trimStr=strHandle("    来吧，小伙，一起战斗吧   ",(str)->str.trim());
        System.out.println(trimStr);

        String upper=strHandle("abdfc",(str ->str.toUpperCase()));
        System.out.println(upper);

        String subStr=strHandle("aaaaaddffss",(str -> str.substring(0,3)));
        System.out.println(subStr);
    }

    //需求：用于处理字符串
    public String strHandle(String str, MyFunction myFunction){
        return myFunction.getValue(str);
    }

    @Test
    public void test3(){
        getMax(100L,200L,(x,y)->x+y);
        getMax(200L,300L,(x,y)->x*y);
    }
    //需求：比较两个字段的大小
    public void getMax(Long l1, Long l2 , MyFunction2<Long,Long> myFunction2){
        System.out.println(myFunction2.getValue(l1,l2));
    }

  }
