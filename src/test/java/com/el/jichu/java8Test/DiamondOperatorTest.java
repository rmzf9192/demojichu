package com.el.jichu.java8Test;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


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
}
