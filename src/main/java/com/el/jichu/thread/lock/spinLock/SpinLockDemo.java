package com.el.jichu.thread.lock.spinLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/16 18:48
 * @Version:V1.0
 * @Description:SpinLockDemo
 */
public class SpinLockDemo {
    //原子引用线程
    AtomicReference<Thread> atomicReference=new AtomicReference<>();

    public void myLock(){
        Thread thread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t come in ");

        while(!atomicReference.compareAndSet(null,thread)){
//            System.out.println("有锁了");
        }
    }
    public  void unLock(){
        Thread thread=Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\t invoke in ");

    }
    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo spinLockDemo =
                new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (Exception e){
                e.printStackTrace();
            }
            spinLockDemo.unLock();
        },"AAA").start();
        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (Exception e){
                e.printStackTrace();
            }
            spinLockDemo.unLock();
        },"BBB").start();

    }
}
