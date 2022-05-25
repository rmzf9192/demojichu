package com.el.jichu.thread.threadpool.线程池关闭;

import java.util.concurrent.*;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/26 11:31
 * @Version:V1.0
 * @Description:ThreadPoolTest
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

        for (int i = 0; i <100 ; i++) {
            queue.add(new Task(String.valueOf(i)));
        }

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 4, 2, TimeUnit.SECONDS, queue, Executors.defaultThreadFactory(), new CustomRejectedExecutionHandler());

        poolExecutor.execute(new Task("0"));
        poolExecutor.shutdown();
        System.out.println("workqueue size "+queue.size()+" after shutdown");

    }

    static class Task implements Runnable{

        private String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i <10 ; i++) {
                System.out.println("task "+name+" is running");
            }
            System.out.println("task "+name+" end");
        }
    }
}
