package com.el.jichu.thread.communication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DieLockTest {

    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Buffed(car));
        executorService.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(3); //main 线程sleep几秒钟

        executorService.shutdownNow();// interrupt,中断所有的任务
    }
}
