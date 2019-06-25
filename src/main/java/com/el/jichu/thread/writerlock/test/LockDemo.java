package com.el.jichu.thread.writerlock.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: roman.zhang
 * @Date: 2019/6/25 16:54
 * @Version:V1.0
 * @Description:LockDemo
 */
@Slf4j
public class LockDemo {
    private int i =0;

    public void add(){
        i++;
    }

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();

        for (int i = 0; i <2 ; i++) {
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    lockDemo.add();
                }
            },String.valueOf(i)).start();
        }


        System.out.println("计算结果是："+lockDemo.i);
    }
}
