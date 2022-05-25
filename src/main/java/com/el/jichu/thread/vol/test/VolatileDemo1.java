package com.el.jichu.thread.vol.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.currentThread;

/**
 * @Auther: roman.zhang
 * @Date: 2019/6/25 15:08
 * @Version:V1.0
 * @Description:VolatileDemo1
 */
class MyData{
    /**
     *  加上关键字volatile
     */
     volatile int i =0 ;
    AtomicInteger atomicInteger = new AtomicInteger();
    public void add(){
        this.i=60;
    }

    public synchronized   void addPlus(){
        i++;
    }
    public void atomicAdd(){
        atomicInteger.getAndIncrement();
    }
}
public class VolatileDemo1 {
    //验证是否具有可见性

    public static void isVolatile(){
        MyData myData = new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.add();
            System.out.println(Thread.currentThread().getName()+"\t update number value:"+myData.i);
        },"isVolatile").start();

        while(myData.i == 0){
            System.out.println(Thread.currentThread().getName()+"不知道i");
        }
        System.out.println("volatile 验证是否具有可见性");
    }

    public static void main(String[] args) {
        MyData myData = new MyData();
        //isVolatile();


        for (int i = 0; i <20 ; i++) {
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    myData.addPlus();
                    myData.atomicAdd();
                }
            },String.valueOf(i)).start();
        }

        while(Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+"finally number value :"+myData.i);
        System.out.println(Thread.currentThread().getName()+"finally atomic value :"+myData.atomicInteger);
    }
}
