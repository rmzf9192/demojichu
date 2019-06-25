package com.el.jichu.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/22 20:22
 * @Version:V1.0
 * @Description:TestLock1
 */
public class TestLock1 {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(ticket, "1号窗口").start();
        new Thread(ticket, "2号窗口").start();
        new Thread(ticket, "3号窗口").start();
    }

}

class Ticket implements Runnable {

    private int tick = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            lock.lock(); //上锁

            try {
                if (tick > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                    }

                    System.out.println(Thread.currentThread().getName() + " 完成售票，余票为：" + --tick);
                }
            } finally {
                lock.unlock(); //释放锁
            }
        }
    }

}
