package com.el.jichu.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/14 16:01
 * @Version:V1.0
 * @Description:CASDemo
 *  CAS:比较并交换
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5,2019)+"\t current data:"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5,2014)+"\t current data:"+atomicInteger.get());
    }
}
