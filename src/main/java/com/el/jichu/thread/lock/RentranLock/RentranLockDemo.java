package com.el.jichu.thread.lock.RentranLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable{
    public synchronized void sendSMS()throws Exception{
        System.out.println(Thread.currentThread().getId()+"\t invoke sendSMS()");
        sendMail();
    }
    public synchronized void sendMail()throws Exception{
        System.out.println(Thread.currentThread().getId()+"\t invoke sendMail()");
    }

    Lock lock=new ReentrantLock();
    @Override
    public void run() {
       get();
    }

    private void get() {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getId()+"\t invoke get()");
            set();
        }finally {
            lock.unlock();
        }
    }
    private void set() {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getId()+"\t invoke set()");
        }finally {
            lock.unlock();
        }
    }
}
/**
 * @Auther: roman.zhang
 * @Date: 2019/4/15 22:39
 * @Version:V1.0
 * @Description:RentranLockDemo
 *  同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 */
public class RentranLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();

      /*  new Thread(()->{
            try{
                phone.sendSMS();
            }catch (Exception e){
                e.printStackTrace();
            }

        }).start();*/
        System.out.println("+++++++++++++++++++++++++++");
        Thread thread1 = new Thread(phone,"t3");
        Thread thread2 = new Thread(phone,"t4");
        thread1.start();
        thread2.start();
    }
}
