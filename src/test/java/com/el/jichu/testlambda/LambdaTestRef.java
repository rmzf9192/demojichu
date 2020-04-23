package com.el.jichu.testlambda;

import com.el.jichu.domain.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.function.*;
/**
 * 一、方法引用：若 Lambda 体中的功能，已经有方法提供了实现，可以使用方法引用
 * 			  （可以将方法引用理解为 Lambda 表达式的另外一种表现形式）
 *
 * 1. 对象的引用 :: 实例方法名
 *
 * 2. 类名 :: 静态方法名
 *
 * 3. 类名 :: 实例方法名
 *
 * 注意：
 * 	 ①方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 * 	 ②若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，格式： ClassName::MethodName
 *
 * 二、构造器引用 :构造器的参数列表，需要与函数式接口中参数列表保持一致！
 *
 * 1. 类名 :: new
 *
 * 三、数组引用
 *
 * 	类型[] :: new;
 *
 *
 */
public class LambdaTestRef {

    //数组的引用
    @Test
    public void test7() {
        Function<Integer, String[]> function = (args) -> new String[args];
        String[] apply = function.apply(12);
        System.out.println(apply.length);
        for (String str : apply) {
            System.out.println(str);
        }
        Function<Integer, Employee[]> function1 = Employee[]::new;
        Employee[] apply1 = function1.apply(20);
        System.out.println(apply1.length);
        for (Employee employee : apply1) {
            System.out.println(employee);
        }
    }


    //构造器
    @Test
    public void test6() {
        Function<String, Employee> function = (x) -> new Employee();
        System.out.println(function.apply("22"));

        Function<String, Employee> function2 = Employee::new;
        System.out.println(function2.apply("22"));

        BiFunction<String, Integer, Employee> biFunction = Employee::new;

        System.out.println(biFunction.apply("222", 333));
        System.out.println("=============================");
        Supplier<Employee> supplier = () -> new Employee();
        System.out.println(supplier.get());
        Supplier<Employee> supplier1 = Employee::new;
        System.out.println(supplier1.get());
    }
    //类名：：实例方法名
    @Test
    public void test5() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        System.out.println(bp.test("111", "2sda"));

        BiPredicate<String, String> bp1 = String::equals;
        boolean test = bp1.test("jjj", "llll");
        System.out.println(test);

        Function<Employee, String> function = (e) -> e.show();
        System.out.println(function.apply(new Employee()));

        Function<Employee, String> function1 = Employee::show;
        System.out.println(function1.apply(new Employee()));
    }
   //类名::静态方法名
    @Test
    public void test4() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        System.out.println(comparator.compare(12, 34));

        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println(comparator1.compare(34, 23));
    }

    @Test
    public void test3() {
        BiFunction<Double, Double, Double> biFunction = (x, y) -> Math.max(x, y);
        System.out.println(biFunction.apply(12D, 15D));
        System.out.println("--------------------------------");

        BiFunction<Double, Double, Double> biFunction1 = Math::min;
        System.out.println(biFunction1.apply(12.23, 23.23));
    }
    //对象的引用::实例方法名
    @Test
    public void test2() {
        Employee employee = new Employee(1, "小强", 23, 8000);
        Supplier<Integer> supplier = () -> employee.getAge();
        supplier.get();

        Supplier<String> stringSupplier = employee::getName;
        stringSupplier.get();
    }

    @Test
    public void test1() {
        PrintStream out = System.out;
        Consumer<String> com = (str) -> out.println(str);
        com.accept("小桌子，真是好");

        System.out.println("------------------------");

        Consumer<String> consumer = out::println;
        consumer.accept("这个我也试一下啊");

        Consumer<String> c = System.out::println;
        c.accept("jjjj");
    }
}
