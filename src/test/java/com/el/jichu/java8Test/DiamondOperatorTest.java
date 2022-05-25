package com.el.jichu.java8Test;

import lombok.val;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


public class DiamondOperatorTest {

    @Test
    public void testDiamondOperator() {
        diamondOperator();
    }

    public void diamondOperator() {
//        Set<String> set = new HashSet<>(){};//编译不通过
        Set<String> set = new HashSet<>();//类型推断
        set.add("MM");
        set.add("JJ");
        set.add("GG");
        set.add("DD");

        for (String s : set) {
            System.out.println(s);
        }

    }

    @Test
    public void test1(){
//        IntStream.range(1, 10)
//                .peek(x -> System.out.print("\nA" + x))
//                .limit(3)
//                .peek(x -> System.out.print("B" + x))
//                .forEach(x -> System.out.print("C" + x));
//
//        IntStream.range(1, 10)
//                .peek(x -> System.out.print("\nA" + x))
//                .skip(6)
//                .peek(x -> System.out.print("B" + x))
//                .forEach(x -> System.out.print("C" + x));

        val strings = new ArrayList<String>();
        strings.add("a");
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");

        val collect = strings.stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.entrySet().stream().forEachOrdered((k)->{
            if(k.getValue()>1){
                System.out.println(k.getKey());
            }
        });
        System.out.println();
    }
}
