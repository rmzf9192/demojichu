package com.el.jichu.thread.interrupt;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author roman zhangfei
 * @Date 2020/1/7 10:03
 * @Version V1.0
 */
public class TestLockInterruptibly {
    public void test3() throws Exception {
        final Lock lock = new ReentrantLock();
        lock.lock();

        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    Thread.sleep(2000);
                    lock.lockInterruptibly();
                }
                catch(InterruptedException e)
                {
                    System.out.println(Thread.currentThread().getName() + " interrupted.");
                }
            }
        }, "child thread -1");

        t1.start();
        Thread.sleep(1000);

        t1.interrupt();

        Thread.sleep(1000000);
    }

    public static void main(String[] args) throws Exception
    {
        new TestLockInterruptibly().test3();
    }

}