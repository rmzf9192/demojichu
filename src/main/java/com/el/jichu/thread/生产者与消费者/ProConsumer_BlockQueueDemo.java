package com.el.jichu.thread.生产者与消费者;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource{
    private volatile boolean flag=true;//默认开启，进行生产+消费
    private AtomicInteger atomicInteger=new AtomicInteger();

    BlockingQueue<String> blockingQueue=null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }
    public void myProd() throws InterruptedException {
        String data=null;
        boolean retValue;
        while(flag){
            data = atomicInteger.incrementAndGet()+"";
            retValue= blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName()+"\t 插入成功"+data);
            }else{
                System.out.println(Thread.currentThread().getName()+"\t 插入失败"+data);
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t 大老板叫停了，表示flag=false，生产动作结束"+data);
    }

    public void myConsumer() throws InterruptedException {
        String result=null;
        while(flag){
            result=blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(null==result||result.equalsIgnoreCase("")){
                flag=false;
                System.out.println(Thread.currentThread().getName()+"\t 超过2秒没有收到蛋糕，消费退出");
                System.out.println();
                System.out.println();
                System.out.println();
                return;

            }
            System.out.println(Thread.currentThread().getName()+"\t 消费成功"+result);
        }
    }
    public  void stop(){
        this.flag=false;
    }
}
/**
 * @Auther: roman.zhang
 * @Date: 2019/4/20 20:09
 * @Version:V1.0
 * @Description:ProConsumer_BlockQueueDemo
 *  volatile/cas/atomicInteger/BlockQueue/线程交互/原子引用
 */
public class ProConsumer_BlockQueueDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 生产");
            try{
                myResource.myProd();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 消费");
            try{
                myResource.myConsumer();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5秒钟时间到，大老板叫停");
        myResource.stop();
    }
}
