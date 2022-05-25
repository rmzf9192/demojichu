package com.el.jichu.thread.writerlock;

import java.util.concurrent.locks.Lock;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/10 15:15
 * @Version:V1.0
 * @Description:LockDomo2
 */
public class LockDomo2 {
    private  int i;
    //private AtomicInteger atomicInteger=new AtomicInteger(0);
    private Lock customLock=new CustomLock();
    public  void add(){
        customLock.lock();
        try {
            i++;

        } finally {
            customLock.unlock();
        }
        //atomicInteger.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        LockDomo2 demo2 = new LockDomo2();
        for(int i=0;i<2;i++){
            new Thread(()->{
                for(int j=0;j<10000;j++){
                    demo2.add();
                }
            }).start();
        }

        Thread.sleep(3000);

        // System.out.println("计算结果是："+demo1.atomicInteger);
        System.out.println("计算结果是："+demo2.i);
    }

}
