package com.el.jichu.thread.writerlock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/10 8:44
 * @Version:V1.0
 * @Description:LockDemo1
 */
public class LockDemo1 {
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    private int i=0;
    private Lock lock=new ReentrantLock();

    static Unsafe unsafe=null;
    private static  long valueOffset;
    static {
        //反射
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe= (Unsafe) theUnsafe.get(null);
            //目标：通过unsafe去调用底层硬件原语
            //无法直接操作内存，委屈求全，只能去通过对象中属性的偏移量，去修改值
            valueOffset = unsafe.objectFieldOffset(LockDemo1.class.getDeclaredField("i"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public  void add(){
        ///使用CAS去实现同步
        //为什么是个循环：因为CAS会失败，因此才会使用循环
        int current ;
        do{
            current=unsafe.getIntVolatile(this,valueOffset);
        }while(!unsafe.compareAndSwapInt(this,valueOffset,current,current+1));
        /**
         * unsafe.compareAndSwapInt(当前对象，内存值，当前值，新值)
         */
       /* lock.lock();
        try {
            i++;
        } finally {
            lock.unlock();
        }*/
        //i++;
       //atomicInteger.getAndIncrement(); //执行参数 -XX:+PrintCommandLineFlags -version
    }

    public static void main(String[] args) throws InterruptedException {
        LockDemo1 demo1 = new LockDemo1();
        for(int i=0;i<2;i++){
            new Thread(()->{
                for(int j=0;j<10000;j++){
                    demo1.add();
                }
            },String.valueOf(i)).start();
        }

        Thread.sleep(3000);

       // System.out.println("计算结果是："+demo1.atomicInteger);
        System.out.println("计算结果是："+demo1.i);
    }

}
