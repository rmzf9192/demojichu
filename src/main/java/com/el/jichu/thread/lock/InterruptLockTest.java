package com.el.jichu.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptLockTest {
    Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        InterruptLockTest test = new InterruptLockTest();
        Thread myThread1 = new MyThread(test);
        Thread myThread2 = new MyThread(test);

        myThread1.start();
        myThread2.start();

        Thread.sleep(2000);
        myThread2.interrupt();
    }

    public void test(Thread thread) throws InterruptedException {
        lock.lockInterruptibly();//注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将InterruptedException抛出

        try {
            System.out.println(Thread.currentThread().getName() + "得到了锁");

            long startTime = System.currentTimeMillis();

            for (; ; ) {
                if (System.currentTimeMillis() - startTime > Integer.MAX_VALUE) {
                    break;
                }
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + "finally执行了");
            lock.unlock();
            System.out.println(thread.getName() + "锁释放了");
        }
    }
}
