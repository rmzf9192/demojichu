package com.el.jichu.testlambda;

import com.el.jichu.dao.MyFun;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

public class LambdaTest2 {

    //无参数，无返回值
    @Test
    public void test1() {
        int num = 0;//jdk1.7之前报错，必须用final修饰
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello word " + num);
            }
        };
        runnable.run();
        System.out.println("-----------------------");

        Runnable runnable1 = ()-> System.out.println("Runnable is running ");
        runnable1.run();
    }
    //语法格式二：一个参数 （消费者接口）
    @Test
    public void test2() {
        Consumer com = (x) -> System.out.println(x);
        com.accept("小伙子，你需要更加努力啊");
    }
    //
    @Test
    public void test3() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        System.out.println(comparator.compare(12, 13));
    }

    @Test
    public void test4() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        System.out.println(comparator.compare(12, 13));
    }
    public void show(Map<String, Integer> map) {

    }

    @Test
    public void test5() {
        List<String> list = new ArrayList<>();
        show(new HashMap<>());
    }

    public Integer operator(Integer integer, MyFun mf) {
        return mf.getValue(integer);
    }

    @Test
    public void test6() {
        Integer num = operator(12, (x) -> x * x);
        System.out.println(num);
        System.out.println(operator(20, (y) -> y + 200));
    }
}
