package com.el.jichu.thread.cas.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Roman.zhang
 * @Date: 2019/6/27 9:01
 * @Version:V1.0
 * @Description:ABADemo1
 */
public class ABADemo1 {
   static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

   static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {
        System.out.println("CAS的ABA问题重现");

        new Thread(()->{
          atomicReference.compareAndSet(100,101);
          atomicReference.compareAndSet(101,100);
        },"t1").start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100,2019)+"\t"+atomicReference.get());
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CAS的ABA问题避免");

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" 第一次版本"+stampedReference.getStamp()+"号");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stampedReference.compareAndSet(100,101,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+" 第一次修改的版本号"+stampedReference.getStamp());
            stampedReference.compareAndSet(101,100,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+" 第二次修改的版本号"+stampedReference.getStamp());
        },"t3").start();


        new Thread(()->{
            int stamp=stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"第一次版本号"+stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean flag = stampedReference.compareAndSet(100, 2019, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName()+"修改是否成功："+flag+" 版本号"+stampedReference.getStamp());

            System.out.println(Thread.currentThread().getName()+"最新的版本值："+stampedReference.getReference());
        },"t4").start();
    }

}
