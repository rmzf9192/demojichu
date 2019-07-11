package com.el.jichu.thread.writerlock.test;

import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: roman.zhang
 * @Date: 2019/6/25 16:54
 * @Version:V1.0
 * @Description:LockDemo
 */
@Slf4j
public class LockDemo {
    private  int i =0;
   // private Lock lock= new ReentrantLock();
    private Lock lock= new CustomLockDemo();
    private AtomicInteger atomicInteger=  new AtomicInteger(0);

    static Unsafe unsafe= null;

    private static long valueOff;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);

            unsafe= (Unsafe) theUnsafe.get(null);
            valueOff = unsafe.objectFieldOffset(LockDemo.class.getDeclaredField("i"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public  void add(){
        //使用CAS实现多线程同步
       /* int current;
        do{
            current =  unsafe.getIntVolatile(this,valueOff);
        }while(!unsafe.compareAndSwapInt(this,valueOff,current,current+1));*/
        lock.lock();
        try {
            i++;
        } finally {
            lock.unlock();
        }
//        atomicInteger.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        LockDemo lockDemo = new LockDemo();

        for (int i = 0; i <2 ; i++) {
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    lockDemo.add();
                }
            },String.valueOf(i)).start();
        }

        Thread.sleep(3000);

        System.out.println("计算结果是："+lockDemo.i);
        System.out.println("计算结果是："+lockDemo.atomicInteger);
    }
}
