package com.el.jichu.thread.threadpool;

import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
        for (int i = 0; i < 20; i++) {
            threadPool.execute(new Task("任务" + i));
        }
        try {
            TimeUnit.SECONDS.sleep(4);
            threadPool.shutDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
