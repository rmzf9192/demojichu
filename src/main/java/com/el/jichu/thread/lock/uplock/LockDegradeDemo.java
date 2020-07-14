package com.el.jichu.thread.lock.uplock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Roman.Zhang
 * @date 2020/5/11
 * @description:锁降级的应用场景
 *              对于数据比较敏感, 需要在对数据修改以后, 获取到修改后的值, 并进行接下来的其它操作
 */
public class LockDegradeDemo {

    private int i = 0;

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock writerLock = readWriteLock.writeLock();
    private Lock readLock = readWriteLock.writeLock();

    public void doSomething() {
        writerLock.lock();
        try {
            i++;
            readLock.lock();
        } finally {
            writerLock.unlock();
        }
        try {
            // 模拟其它复杂操作
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            if (i == 1) {
                System.out.println("i的值是" + i);
            } else {
                System.out.println("i = " + i);
            }
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        LockDegradeDemo lockDegradeDemo = new LockDegradeDemo();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                lockDegradeDemo.doSomething();
            }).start();
        }
    }

}
