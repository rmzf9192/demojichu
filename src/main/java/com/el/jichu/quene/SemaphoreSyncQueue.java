package com.el.jichu.quene;

import java.util.concurrent.Semaphore;

/**
 * @author Roman.zhang
 * @Date: 2019/6/28 14:58
 * @Version:V1.0
 * @Description:SemaphoreSyncQueue
 */
public class SemaphoreSyncQueue<E> {
    E item =  null ;

   Semaphore sync= new Semaphore(0);
   Semaphore send= new Semaphore(1);
   Semaphore recv= new Semaphore(0);
    public E take() throws InterruptedException {
        System.out.println("take recv 执行前");
        recv.acquire();
        System.out.println("take recv 执行后");
        E x =item;
        System.out.println("take sync 执行前");
        sync.release();
        System.out.println("put sync 执行后");
        System.out.println("take send 执行前");
        send.release();
        System.out.println("take send 执行后");

        return x;
    }


   public void put(E x) throws InterruptedException {
       System.out.println("put send 执行前");
       send.acquire();
       System.out.println("put send 执行后");
       item = x;
       System.out.println("put recv 执行前");
       recv.release();
       System.out.println("put recv 执行后");
       System.out.println("put sync 执行前");
       sync.acquire();
       System.out.println("put sync 执行后");

   }

    public static void main(String[] args) {
        SemaphoreSyncQueue<Integer> semaphoreSyncQueue = new SemaphoreSyncQueue<>();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"put");
            try {
                semaphoreSyncQueue.put(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();

        new Thread(()->{
            try {
                semaphoreSyncQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BB").start();

    }
}
