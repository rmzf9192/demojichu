package com.el.jichu.thread.yeild;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/15 19:00
 * @Version:V1.0
 * @Description:YieldDemo
 */
public class YieldDemo {
        public static void main(String[] args) throws InterruptedException {
            Thread producer = new Producer();
            Thread consumer = new Consumer();

            producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
            consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority

            producer.start();
            producer.join();
            consumer.start();
        }
    }

    class Producer extends Thread
    {
        public void run()
        {
            for (int i = 0; i < 5; i++)
            {
                System.out.println("I am Producer : Produced Item " + i);
                Thread.yield();
            }
        }
    }

    class Consumer extends Thread
    {
        public void run()
        {
            for (int i = 0; i < 5; i++)
            {
                System.out.println("I am Consumer : Consumed Item " + i);
                Thread.yield();
            }
        }
    }
