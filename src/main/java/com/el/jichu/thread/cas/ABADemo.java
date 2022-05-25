package com.el.jichu.thread.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/14 17:25
 * @Version:V1.0
 * @Description:ABADemo
 */
public class ABADemo {//ABA问题的解决，
    static  AtomicReference<Integer> reference = new AtomicReference<>(100);
    static  AtomicStampedReference<Integer> referenceS = new AtomicStampedReference<>(100,1);
    public static void main(String[] args) {
       new Thread(()->{
           reference.compareAndSet(100,101);
           reference.compareAndSet(101,100);
       },"t1").start();
        System.out.println("以下是ABA问题");
       new Thread(()->{
           try{
               //暂停1秒钟t2线程，保证上面的t1线程完成了一次ABA操作
               TimeUnit.SECONDS.sleep(1);
           }catch (Exception e){
               e.printStackTrace();
           }
           System.out.println(reference.compareAndSet(100,2019)+"\t"+reference.get());
       },"t2").start();

        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("以下是ABA问题的解决");
        new Thread(()->{
            int stamp = referenceS.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第一次版本号" +stamp);
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
            referenceS.compareAndSet(100,101,referenceS.getStamp(),referenceS.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t 第2次版本号" +referenceS.getStamp());
            referenceS.compareAndSet(101,100,referenceS.getStamp(),referenceS.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t 第3次版本号" +referenceS.getStamp());

        },"t3").start();

        new Thread(()->{
            int stamp = referenceS.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第1次版本号" +stamp);
            try{
                TimeUnit.SECONDS.sleep(3);
            }catch (Exception e){
                e.printStackTrace();
            }
           boolean flag= referenceS.compareAndSet(100,2019,stamp,stamp+1);
            referenceS.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 修改成功否："+flag+"当前最新版本号"+referenceS.getStamp());

            System.out.println(Thread.currentThread().getName()+"\t 当前实际最新值："+referenceS.getReference());
        },"t4").start();
    }
}
