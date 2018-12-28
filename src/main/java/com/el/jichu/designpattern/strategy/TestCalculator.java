package com.el.jichu.designpattern.strategy;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/28 11:32
 * @Version:V1.0
 * @Description:TestCalculator
 */
public class TestCalculator {
    public static void main(String[] args) {
        String exp="2+8";
        Calculator plus = new Plus();
        int calculate = plus.calculate(exp);
        System.out.println(calculate);
    }
}
