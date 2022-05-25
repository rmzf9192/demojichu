package com.el.jichu.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
    public static void main(String[] args) {
        /**
         * 1.在使用有界队列的时候：若有新的任务需要执行，如果线程池实际线程数小于corePoolSize核心线程数的时候，则优先创建线程。
         * 若大于corePoolSize时，则会将多余的线程存放在队列中，
         * 若队列已满，且最请求线程小于maximumPoolSize的情况下，则自定义的线程池会创建新的线程，
         * 若队列已满，且最请求线程大于maximumPoolSize的情况下，则执行拒绝策略，或其他自定义方式。
         */
        ThreadPoolExecutor pool = new ThreadPoolExecutor(// 自定义一个线程池
                1, // coreSize
                2, // maxSize
                60, // 60s
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3) // 有界队列，容量是3个
        );
        for (int i = 0; i < 5; i++) {
            MyTask task1 = new MyTask(i, "task1");
            pool.execute(task1);
        }
/*
        MyTask task1 = new MyTask(1, "task1");
        MyTask task2 = new MyTask(2, "task2");
        MyTask task3 = new MyTask(3, "task3");
        MyTask task4 = new MyTask(4, "task4");
        MyTask task5 = new MyTask(5, "task5");
        MyTask task6 = new MyTask(6, "task6");
        *//**
         * 此处可以一步步打开看执行结果是不是符合上面注释所说的情况。
         *//*
        pool.execute(task1);
        pool.execute(task2);
        pool.execute(task3);
        pool.execute(task4);
        pool.execute(task5);
        pool.execute(task6);*/

        pool.shutdown();
    }


}
