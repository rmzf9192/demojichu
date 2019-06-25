package com.el.jichu.thread.writerlock;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/10 10:32
 * @Version:V1.0
 * @Description:CustomLock
 *    思路
 *       1.没有获取锁的线程，如何让线程挂起，不在往下执行，等待其他线程释放锁。
 *       2.释放锁之后，如何通知其他线程去获取锁
 */
public class CustomLock implements Lock {
    //锁的拥有者
    AtomicReference<Thread> owner=new AtomicReference<>();

    //一个容器存储等待的线程
    ConcurrentHashMap<Thread,Object> queue=new ConcurrentHashMap<>();

    @Override
    public void lock() {
       while( !owner.compareAndSet(null,Thread.currentThread())){
           //没有获取成功，则将该线程停下来
           queue.put(Thread.currentThread(),"");
           //正在运行的线程进入停车场
           LockSupport.park();
           queue.remove(Thread.currentThread());
       }

    }
    @Override
    public void unlock() {
          while(owner.compareAndSet(Thread.currentThread(),null)){//释放锁
              //通知其他线程去park线程，继续去强锁
              //  Thread next=null;
              ConcurrentHashMap.KeySetView<Thread, Object> threads = queue.keySet();
              for(Thread t:threads){
                  LockSupport.unpark(t);
              }
          }
    }



    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}
