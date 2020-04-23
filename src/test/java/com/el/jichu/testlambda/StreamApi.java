package com.el.jichu.testlambda;

import com.el.jichu.domain.Employee;
import lombok.val;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {

    @Test
    public void test() {
        //1.Collection提供了两个方法，Stream(),parallelStream()
        List<String> list = new ArrayList<>();
        //获取一个顺序流
        Stream<String> stream = list.stream();
        //获取一个并行流,并行与并发的区别
        Stream<String> stringStream = list.parallelStream();
        System.out.println(stream.map((e) -> Integer.parseInt(e)));

        //2.通过Arrays中的Stream获取一个数组流
        Integer[] integerArr = new Integer[2];
        List<Integer> list1 = new ArrayList<>(Arrays.asList(integerArr));
        list1.add(12);
        list1.add(13);
        System.out.println(list1.size());
        Integer[] in = new Integer[list1.size()];
        list1.toArray(in);
        Stream<Integer> stream1 = Arrays.stream(in);
        stream1.forEach(System.out::println);

        //3.通过Stream中的静态方法of获取
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        List<Integer> collect = integerStream.collect(Collectors.toList());


        integerStream.forEach(System.out::println);
        //4.创建无限流
         //迭代
        Stream<Integer> limit = Stream.iterate(0, (x) -> x + 2).limit(3);
        limit.forEach(System.out::println);
        System.out.println("---------------------------");
         //生成
        Stream<Double> limit1 = Stream.generate(Math::random).limit(3);
        limit1.forEach(System.out::println);
    }

    //2. 中间操作
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );
    /*
     筛选与切片
       filter:接收lambda语法，从流中排除某些元素
       limit:截断流，使元素不超过指定的数量
       skip:跳过元素，扔掉前n个元素，如果不足n个，返回空流，与limit互补
       distinct:筛选，通过流产生的hashCode与equal删除重复元素
     */

    @Test
    public void test2() {
        //所有的中间操作都不会做任何处理
        Stream<Employee> employeeStream = emps.stream()
                .filter((e) -> {
                    System.out.println("中间操作");
                    return e.getAge() > 35;
                });
        employeeStream.forEach(System.out::println);
    }

    @Test
    public void test3() {
        //外部迭代
        Iterator<Employee> it = emps.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @Test
    public void test4() {
        emps.stream()
                .filter((e) -> {
                    System.out.println("短路与");
                    return e.getSalary() > 5000;
                })
                .limit(3)
                .forEach(System.out::println);
        System.out.println("---------------------------");

        emps.stream()
                .filter((e) -> e.getSalary() > 5000)
                .skip(2)
                .forEach(System.out::println);
        System.out.println("----------------------------");

        emps.stream()
                .distinct()
                .forEach(System.out::println);
    }

    //需求：返回由每个数的平方构成的列表

    @Test
    public void test5() {
        Integer[] nmums = new Integer[]{1, 2, 3, 4};

        Arrays.stream(nmums)
                .map((e) -> e * e)
                .forEach(System.out::println);
    }

    //怎么使用map与reduce数一数流中有多少employee
    @Test
    public void test6() {
        Optional<Integer> count = emps.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
        System.out.println(count.get());
    }
}
