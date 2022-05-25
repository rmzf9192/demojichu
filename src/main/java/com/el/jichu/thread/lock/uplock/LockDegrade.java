package com.el.jichu.thread.lock.uplock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Roman.Zhang
 * @date 2020/5/11
 * @description: 锁降级：写线程获取写入锁后可以获取读取锁, 然后释放写入锁, 这样就从写入锁变成了读取锁, 从而实现锁降级的特征
 *    锁降级以后, 写锁并不会直接降成读锁, 不会随着读锁的释放而释放, 因此需要显式地释放写锁。
 */
public class LockDegrade {
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        Lock writeLock = reentrantReadWriteLock.writeLock();
        Lock readLock = reentrantReadWriteLock.readLock();
        writeLock.lock();
        readLock.lock();
        writeLock.unlock();
        readLock.unlock();

        System.out.println("程序正常运行");

    }

}
