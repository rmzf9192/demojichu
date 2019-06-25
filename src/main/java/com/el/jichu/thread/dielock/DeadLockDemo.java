package com.el.jichu.thread.dielock;

import java.util.concurrent.TimeUnit;

class DeadLockThread implements Runnable{

    private String lockA;
    private String lockB;

    public DeadLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有："+lockA+"尝试 获得"+lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 自己持有："+lockB+"尝试 获得"+lockA);
            }
        }
    }
}
/**
 * @Auther: roman.zhang
 * @Date: 2019/4/22 22:08
 * @Version:V1.0
 * @Description:DeadLockDemo
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA="lockA";
        String lockB="lockB";
            new Thread(new DeadLockThread(lockA,lockB),"ThreadA").start();
            new Thread(new DeadLockThread(lockB,lockA),"ThreadB").start();

        /**
         * linux ps -ef|grep
         * window  jps=java ps jps -l
         * jstack 进程号
         */
    }
}
