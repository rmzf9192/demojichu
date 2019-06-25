package com.el.jichu.thread.vol;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/14 11:06
 * @Version:V1.0
 * @Description:VolatileDemo
 */
class MyData{
    volatile int i=0;

    public void add60(){
        this.i=60;
    }
    //请注意，此时i前面是加了volatile关键字装饰的，不保证原子性--最终一致性

    /**
     * 加synchronized
     */
    public void addPlusPlus(){
        i++;
    }
    public void addAtomic(){
        integer.getAndIncrement();
    }
    AtomicInteger integer= new AtomicInteger();
}
public class VolatileDemo {
    public static void main(String[] args) {
        System.out.println("你好");
        setOkVolatile();
        MyData myData = new MyData();

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            },String.valueOf(i)).start();
        }

        //需要等待上面20个线程全部计算完成后。在用main线程取得最终的结果值看是多少？
    /*    try{
            TimeUnit.SECONDS.sleep(5);

        }catch (Exception e){
            e.printStackTrace();
        }*/
       while(Thread.activeCount()>2){
           Thread.yield();
       }

        System.out.println(Thread.currentThread().getName()+"\t finallly number value:"+myData.i);

        System.out.println(Thread.currentThread().getName()+"\t atomic number value:"+myData.integer);

    }

    //volatile不保证原子性的案例演示

    /**
    volatile可以保证可见性，及时通知其他线程，主物理内存的值已经被修改
    添加了volatile，可以解决可见性
    验证volatile不保证原子性
    原子性指的是什么意思？
    不可分割，完整性，也即某个线程正在做某个具体具体业务时，中间不可以被加塞或者被分割，
    需要整体完整，要么同时成功，要么同时失败
     volatile不保证原子性的案例演示
     为什么不能保证原子性
     如何解决AtomicInteger
     使用Lock synchronized
   */
    private static void setOkVolatile() {
        MyData myData = new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try{
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            myData.add60();
            System.out.println(Thread.currentThread().getName()+"\t update number value:"+myData.i);
        },"AAA").start();

        //第二个线程就是我们的main线程
        while(myData.i==0){
            System.out.println("不知道");
        }
        System.out.println(Thread.currentThread().getName()+"\t missoin is over main get i"+myData.i);
    }
}
