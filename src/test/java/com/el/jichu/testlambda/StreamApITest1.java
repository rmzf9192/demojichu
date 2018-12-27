package com.el.jichu.testlambda;


import com.el.jichu.domain.Employee;
import com.el.jichu.domain.Employee.Status;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream操作流程
 *   1.创建Stream流
 *   2.中间操作
 *   3.终止操作
 */
public class StreamApITest1 {

    // 中间操作s
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66, Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Status.BUSY)
    );
    /*
    中间操作
    映射
    map:lambda，将元素转换为其他形式或者提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
    flatMap:将函数作为参数，将所有流中的每一个值都换成另一个流，并将所有的流连接一个流
     */
    @Test
    public void test1(){
        Stream<String> stringStream = emps.stream()
                .map((e) -> e.getName());
        System.out.println("------------------------");

        List<String> list = Arrays.asList("jj", "aa", "acc", "jj", "bb");

        Stream<String> stringStream1 = list.stream()
                .map(String::toUpperCase);
       stringStream1.forEach(System.out::println);

        System.out.println("------------------------");
        Stream<Stream<Character>> streamStream = list.stream()
                .map(StreamApITest1::filterCha);
        //streamStream.forEach(System.out::println);
        System.out.println("+++++++++++++++++++++++++++++");
        streamStream.forEach((ss)->{
            ss.forEach(System.out::println);
        });

        System.out.println("flatMap方式");

        Stream<Character> characterStream = list.stream()
                .flatMap(StreamApITest1::filterCha);

        characterStream.forEach(System.out::println);

        /*
        sorted排序
          sorted():自然排序
          sorted()
         */
        System.out.println("sorted排序：");
        emps.stream()
        .map(Employee::getName)
        .sorted()
        .forEach(System.out::println);
        System.out.println("---------------------");

        emps.stream()
                .sorted((a,b)->{
                    if (a.getAge() == b.getAge()) {
                        return a.getName().compareTo(b.getName());
                    }else{
                        return Integer.compare(a.getAge(),b.getAge());
                    }
                }).forEach(System.out::println);


    }
    public static Stream<Character> filterCha(String str){
        List<Character> list=new ArrayList<>();
        for(Character character:str.toCharArray()){
            list.add(character);
        }
        return list.stream();
    }
    /**
     * 终止操作
     *   allMatch-检查是否匹配所有元素
     *   anyMatch-检查是否至少匹配一个元素
     *   noneMatch-检查是否没有匹配元素
     *   findFirst-返回第一个元素
     *   findAny-返回当前流的任意元素
     *   count-返回当前流的总个数
     *   min-返回当前流的最小值
     *   max-返回当前流的最大值
     */

    @Test
    public void test2(){
        //检查是否匹配所有的元素
        boolean b = emps.stream()
                .allMatch((e) -> Status.BUSY.equals(e.getStatus()));
        System.out.println("allMatch:"+b);

        //检查是否至少匹配一个元素
        boolean b1 = emps.stream()
                .anyMatch((e) -> Status.BUSY.equals(e.getStatus()));
        System.out.println("anyMatch:"+b1);

        //检查是否没有匹配的元素
        boolean b2 = emps.stream()
                .noneMatch((e) -> Status.BUSY.equals(e.getStatus()));
        System.out.println("noneMatch:"+b2);

        //返回第一元素
        Optional<Employee> first = emps.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println("返回第一个元素："+first.get());

        Optional<Employee> any = emps.stream()
                .filter((e) -> Status.BUSY.equals(e.getStatus()))
                .findAny();
        System.out.println("返回任意元素："+any.get());

        //返回当前流中的总个数
        long count = emps.stream()
                .filter((e) -> Status.BUSY.equals(e.getStatus()))
                .count();
        System.out.println("当前流中的总个数："+count);

        Optional<Double> max = emps.stream()
                .map(Employee::getSalary)
                .max(Double::compareTo);
        System.out.println("返回当前流中薪水最高金额："+max.get());

        Optional<Employee> min = emps.stream()
                .min((m1, m2) -> Double.compare(m1.getSalary(), m2.getSalary()));

        System.out.println("获得最小的薪水的员工信息："+min.get());

        //注意做了终止操作，不能在操作流
        Stream<Employee> employeeStream = emps.stream()
                .filter((e) -> e.getAge() > 23);
        System.out.println("年龄大于23岁的个数："+employeeStream.count());

        Optional<Integer> max1 = employeeStream.map(Employee::getAge).max(Integer::compareTo);

        System.out.println("终止流操作后："+max1.get());
    }
    /*
    终止操作
      reduce:(T identity, BinaryOperator<T> accumulator);/(BinaryOperator<T> accumulator);
       -可以将流中的元素反复结合起来，得到一个值
     */
    @Test
    public void test3(){
       List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9);

        Integer reduce = list.stream()
                .reduce(100, (x, y) -> x + y,(a,b)->a+b);
        System.out.println("reduce获取的结果："+reduce);
        Optional<Double> reduce1 = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println("所有员工的总薪水:"+reduce1.get());

        Stream<String> stringStream = emps.stream()
                .map(Employee::getName)
                .flatMap(TestTransaction::filterString);
        System.out.println("flatMap获取的数据："+stringStream.collect(Collectors.toList()));

        //找到名字中含有'六'的员工数
        Optional<Integer> reduce2 = emps.stream()
                .map(Employee::getName)
                .flatMap(TestTransaction::filterString)
                .map((ch) -> {
                    if (("六").equals(ch)) {
                        return 1;
                    } else {
                        return 0;
                    }
                }).reduce(Integer::sum);

        System.out.println("测试获取的是什么："+reduce2.get());

    }
    //collection:将流转化为其他形式。接收一个collector接口的实现，用于给stream中的元素做为汇总的方法

    @Test
    public void test4(){
        List<String> collect = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.print("Collectors.toList:");
        collect.forEach(System.out::print);
        System.out.println("--------------------------------");
        Set<String> collect1 = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        collect1.forEach(System.out::println);
        System.out.println("--------------------------------");

        HashSet<String> collect2 = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

        collect2.forEach(System.out::println);

    }

    /*
    接收一个collector接口的实现，用于给stream中的元素做为汇总的方法
     */
    @Test
    public void test5(){
        //Collectors.minBy():获取最小的值的内容
        //第一种方式
        Optional<Double> collect = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));

        System.out.println("Collectors的minBy() 打印信息："+collect.get());
        //第二种方式
        Optional<Employee> collect1 = emps.stream()
                .collect(Collectors.minBy((x, y) -> Double.compare(x.getSalary(), y.getSalary())));
        System.out.println("-----"+collect1.get());

        Double collect2 = emps.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println("Collectors的summingDouble方法："+collect2);

        Double collect3 = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("Collectors的averagingDouble :"+collect3);

        Long collect4 = emps.stream()
                .collect(Collectors.counting());
        System.out.println("counting:"+collect4);

        DoubleSummaryStatistics collect5 = emps.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println("summarizingDouble:"+collect5.getMax());
        System.out.println("summarizingDouble:"+collect5);
        //分组
        Map<String, List<Employee>> collect6 = emps.stream()
                .collect(Collectors.groupingBy(Employee::getName));
        System.out.println("Collectors的groupingBy:"+collect6);

        //多级分组
        Map<String, Map<String, List<Employee>>> collect7 = emps.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.groupingBy((e) -> {
                    if (e.getAge() > 60) {
                        return "老年人";
                    } else if (e.getAge() >= 35) {
                        return "中年";
                    } else {
                        return "青年";
                    }
                })));
        System.out.println("多级分组的信息："+collect7);

        ///分区
        Map<Boolean, List<Employee>> collect8 = emps.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() >=5000));

        System.out.println("分区Map:"+collect8);

        String collect9 = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "---", "----"));

        System.out.println("joining打印信息："+collect9);

        Optional<Double> collect10 = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.reducing(Double::sum));

        System.out.println("Collectors.reducing:"+collect10.get());

    }
 }
