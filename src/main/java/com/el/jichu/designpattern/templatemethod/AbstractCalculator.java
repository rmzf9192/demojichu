package com.el.jichu.designpattern.templatemethod;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/2 15:10
 * @Version:V1.0
 * @Description:AbstractCalculator 抽象类
 */
public abstract class AbstractCalculator {
    //主方法实现对本类其他方法的调用
    public final int calculator(String exp, String opt) {
        int[] split = split(exp, opt);
        return calculator(split[0], split[1]);
    }

    //被子类重写的方法
    abstract public int calculator(int num1, int num2);

    public int[] split(String exp, String opt) {
        String[] split = exp.split(opt);
        int[] ints = new int[2];
        ints[0] = Integer.parseInt(split[0]);
        ints[1] = Integer.parseInt(split[1]);
        return ints;
    }

}
