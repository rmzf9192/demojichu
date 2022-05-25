package com.el.jichu.designpattern.strategy;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/28 11:31
 * @Version:V1.0
 * @Description:Minus
 */
public class Minus extends AbstractCalculator implements Calculator {
    @Override
    public int calculate(String exp) {
        int[] split = split(exp, "-");
        return split[0] - split[1];
    }
}
