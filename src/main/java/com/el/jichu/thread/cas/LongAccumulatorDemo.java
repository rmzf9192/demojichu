package com.el.jichu.thread.cas;

import java.util.concurrent.atomic.LongAccumulator;

/**
 * @author roman zhangfei
 * @Date 2019/10/25 11:11
 * @Version V1.0
 */
public class LongAccumulatorDemo {
    public static void main(String[] args) {
        LongAccumulator longAccumulator1 = new LongAccumulator((a,b)->a+b,2);
        LongAccumulator longAccumulator2 = new LongAccumulator((a,b)->a*b,2);

        longAccumulator1.accumulate(31);
        longAccumulator2.accumulate(31);

        System.out.println(longAccumulator1.get());
        System.out.println(longAccumulator2.get());
    }
}
