package com.el.jichu.thread.writerlock.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @Auther: roman.zhang
 * @Date: 2019/6/25 17:56
 * @Version:V1.0
 * @Description:CustomLockDemo
 */
public class CustomLockDemo  implements Lock {
    /**
     *  锁的拥有者
     */

    private  AtomicReference<Thread> owner= new AtomicReference();
    /**
     *  一个容器储存等待的锁
     */

    private ConcurrentHashMap<Thread,Object> queue=new ConcurrentHashMap<>();
    @Override
    public void lock() {
        while(!owner.compareAndSet(null,Thread.currentThread())){
            queue.put(Thread.currentThread(),"");
            //正在运行的线程进入停车场
            LockSupport.park();
            queue.remove(Thread.currentThread());
        }
    }
    @Override
    public void unlock() {
        while(owner.compareAndSet(Thread.currentThread(),null)){
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
