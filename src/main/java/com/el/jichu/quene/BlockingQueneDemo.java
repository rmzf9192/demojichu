package com.el.jichu.quene;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/16 22:18
 * @Version:V1.0
 * @Description:BlockingQueneDemo
 *  1.队列
 *  2.阻塞队列
 *    2.1 阻塞队列有没有好的一面
 *    2.2 不得不阻塞，你如何管理
 *
 */
public class BlockingQueneDemo {
    public static void main(String[] args) throws InterruptedException {
        List list=null;
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);

       /* System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.add("d"));

        System.out.println(blockingQueue.element());

        System.out.println( blockingQueue.remove());
        System.out.println( blockingQueue.remove());
        System.out.println( blockingQueue.remove());*/
      /*  System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());*/
    /*    for (int i = 0; i <4 ; i++) {
            new Thread(()->{
                try {
                    blockingQueue.put("a");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

        TimeUnit.SECONDS.sleep(3);

        for (int i = 0; i <4 ; i++) {
            new Thread(()->{
                try {
                    System.out.println(blockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }*/
      /* blockingQueue.put("a");
       blockingQueue.put("b");
       blockingQueue.put("c");
        System.out.println("===============");
       blockingQueue.put("d");

       blockingQueue.take();
       blockingQueue.take();
       blockingQueue.take();*/
     blockingQueue.offer("a", 2L,TimeUnit.SECONDS);
     blockingQueue.offer("a", 2L,TimeUnit.SECONDS);
     blockingQueue.offer("a", 2L,TimeUnit.SECONDS);
     blockingQueue.offer("a", 2L,TimeUnit.SECONDS);
    }
}
