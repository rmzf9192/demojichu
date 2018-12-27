package com.el.jichu.testlambda;

import com.el.jichu.domain.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.function.*;

public class LambdaTestRef {

    //数组的引用
    @Test
    public void test7(){
        Function<Integer,String[]> function=(args)->new String[args];
        String[] apply = function.apply(12);
        System.out.println(apply.length);
       for(String str:apply){
           System.out.println(str);
       }
       Function<Integer,Employee[]> function1=Employee[]::new ;
        Employee[] apply1 = function1.apply(20);
        System.out.println(apply1.length);
        for(Employee employee:apply1){
            System.out.println(employee);
        }
    }


    //构造器
    @Test
    public void test6(){
        Function<String, Employee> function=(x)->new Employee();
        System.out.println(function.apply("22"));

        BiFunction<String,Integer,Employee> biFunction=Employee::new;

        System.out.println(biFunction.apply("222",333));
        System.out.println("=============================");
       Supplier<Employee> supplier=()->new Employee();
        System.out.println(supplier.get());
        Supplier<Employee> supplier1=Employee::new;
        System.out.println(supplier1.get());
    }

    @Test
    public void test5(){
        BiPredicate<String,String> bp=(x,y)->x.equals(y);
        System.out.println(bp.test("111","2sda"));

        BiPredicate<String,String> bp1=String::equals;
        boolean test = bp1.test("jjj", "llll");
        System.out.println(test);

        Function<Employee,String> function=(e)->e.show();
        System.out.println(function.apply(new Employee()));

        Function<Employee,String> function1=Employee::show;
        System.out.println(function1.apply(new Employee()));
    }

    @Test
    public void test4(){
       Comparator<Integer> comparator=(x,y)-> Integer.compare(x,y);
        System.out.println(comparator.compare(12,34));

        Comparator<Integer> comparator1=Integer::compare;
        System.out.println(comparator1.compare(34,23));
    }

    @Test
    public void test3(){
        BiFunction<Double,Double,Double> biFunction=(x,y)->Math.max(x,y);
        System.out.println(biFunction.apply(12D,15D));
        System.out.println("--------------------------------");

        BiFunction<Double,Double,Double> biFunction1=Math::min;
        System.out.println(biFunction1.apply(12.23,23.23));
    }

    @Test
    public void test2(){
        Employee employee = new Employee(1, "小强", 23, 8000);
        Supplier<Integer> supplier=()->employee.getAge();
        supplier.get();

        Supplier<String> stringSupplier=employee::getName;
        stringSupplier.get();
    }

    @Test
    public void test1(){
        PrintStream out = System.out;
        Consumer<String> com=(str)->out.println(str);
        com.accept("小桌子，真是好");

        System.out.println("------------------------");

        Consumer<String> consumer=out::println;
        consumer.accept("这个我也试一下啊");

        Consumer<String> c=System.out::println;
        c.accept("jjjj");
    }



}
