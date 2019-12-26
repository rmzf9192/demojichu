package com.el.jichu.thread.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author roman zhangfei
 * @Date 2019/10/14 15:42
 * @Version V1.0
 */
public class TestABC {

    public static void main(String[] args) {
        AlternateDemo ad = new AlternateDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 1; i <= 20; i++) {
                    ad.lockA(i);
                }

            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 1; i <= 20; i++) {
                    ad.lockB(i);
                }

            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 1; i <= 20; i++) {
                    ad.lockC(i);

                    System.out.println("-----------------------------------");
                }

            }
        }, "C").start();
    }
}


class AlternateDemo{
    private int i= 1;  //当前正在执行的线程标记

    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void lockA(int total){
        lock.lock();
        try {
        if(i !=1){
            condition1.await();
        }
        for (int j = 1; j <= 1; j++) {
            System.out.println(Thread.currentThread().getName()+"\t"+i+"\t" +total);
        }
        i = 2;
        condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void lockB(int total){
        lock.lock();

        try{
            if(i !=2){
                condition2.await();
            }
            for (int j = 0; j < 1; j++) {
                System.out.println(Thread.currentThread().getName()+"\t" +i+"\t"+total);
            }
            i = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void lockC(int total){
        lock.lock();
        try{
            if(i !=3){
                condition3.await();
            }
            for (int j = 0; j < 1; j++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+total);
            }
            i=1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}