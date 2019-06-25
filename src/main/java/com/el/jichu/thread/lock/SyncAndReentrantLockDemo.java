package com.el.jichu.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class ShareResource{
    private int number=1;

    private Lock lock=new ReentrantLock();
    private Condition c1=lock.newCondition();
    private Condition c2=lock.newCondition();
    private Condition c3=lock.newCondition();

    public void print5(){
        lock.lock();
        try{
            while(number!=1){
                c1.await();
            }
            //干活
            for (int i = 0; i <5 ; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            //通知
            number=2;
            c2.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try{
            while(number!=2){
                c2.await();
            }
            //干活
            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            //通知
            number=3;
            c3.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try{
            while(number!=3){
                c3.await();
            }
            //干活
            for (int i = 0; i <15 ; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            //通知
            number=1;
            c1.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/20 12:34
 * @Version:V1.0
 * @Description:SyncAndReentrantLockDemo
 */
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareResource resource = new ShareResource();
        
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                resource.print5();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                resource.print10();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                resource.print15();
            }
        },"C").start();

    }
}
