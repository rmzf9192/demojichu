package com.el.jichu.designpattern.strategy;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/28 11:24
 * @Version:V1.0
 * @Description:AbstractCalculator：辅助类
 */
public abstract class AbstractCalculator {

    public int[] split(String exp, String opt) {
        String[] split = exp.split(opt);
        int[] ints = new int[2];

        ints[0] = Integer.parseInt(split[0]);
        ints[1] = Integer.parseInt(split[1]);
        return ints;
    }


}
