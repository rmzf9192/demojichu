package com.el.jichu.thread.interrupt;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author roman zhangfei
 * @Date 2020/1/7 10:01
 * @Version V1.0
 */
public class TestLock {
    public void test() throws Exception {
        final Lock lock = new ReentrantLock();
        lock.lock();
        System.out.println(Thread.currentThread().getName() +" 获取了锁");

        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        },"child thread -1");

        t1.start();
        Thread.sleep(1000);

        t1.interrupt();

        Thread.sleep(1000000);
    }

    public static void main(String[] args) throws Exception {
        new TestLock().test();
    }


}