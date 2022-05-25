package com.el.jichu.designpattern.templatemethod;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 11:26
 * @Version:V1.0
 * @Description:Plus
 */
public class Plus extends AbstractCalculator {
    @Override
    public int calculator(int num1, int num2) {
        return num1 + num2;
    }
}
