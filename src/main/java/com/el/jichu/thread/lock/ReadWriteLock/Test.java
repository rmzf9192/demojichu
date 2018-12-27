package com.el.jichu.thread.lock.ReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {
//使用读锁
    private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    public static void main(String[] args) {
        Test test = new Test();

        new Thread(){
            public void run(){
                test.get(Thread.currentThread(),"A");
            }
        }.start();

        new Thread(){
            public void run(){
                test.get(Thread.currentThread(),"B");
            }
        }.start();
       /* new Thread(){
            public void run(){
                test.get(Thread.currentThread(),"C");
            }
        }.start();*/
    }


    public void get(Thread thread,String type){
        //synchronized (this){
        //使用读锁
        lock.readLock().lock();
        try {
            long startTime=System.currentTimeMillis();
            while(System.currentTimeMillis()-startTime<=1){
                System.out.print(type);
                System.out.println(thread.getName()+":正在进行读操作");
            }
            System.out.println("读操作完成");
        } finally {
            lock.readLock().unlock();
        }
        //}

    }

}
