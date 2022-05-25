package com.el.jichu.thread.dielock.test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author Roman.zhang
 * @Date: 2019/6/27 14:42
 * @Version:V1.0
 * @Description:DeadLockDemo
 */
public class DeadLockDemo implements Runnable{

    private String lockA;

    private String lockB;

    public DeadLockDemo(String lockA,String lockB){
        this.lockA = lockA;
        this.lockB = lockB;
    }
    public void DeadLockDemo(){
        System.out.println("测试");
    }


    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"获取"+lockA+ "尝试获取"+lockB);

            try{
                TimeUnit.SECONDS.sleep(3);
            }catch (Exception e){

            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"获取"+lockB+"尝试获取"+lockA);
            }
        }
    }

    public static void main(String[] args) {
       String lockA="lockA";
       String lockB="lockB";
       new Thread(new DeadLockDemo(lockA,lockB),"ThreadA").start();
       new Thread(new DeadLockDemo(lockB,lockA),"ThreadB").start();
    }
}
