package com.el.jichu.thread.communication;

import java.util.concurrent.TimeUnit;

/**
 * 执行抛光任务
 */
public class Buffed implements Runnable {
    private Car car;

    public Buffed(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitWaxOn();
                System.out.println("Buffed:开始抛光-》" + Thread.currentThread().getName());
                //模拟抛光的时间
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();

            }
        } catch (InterruptedException e) {
            System.out.println("Buffed, exiting via interrupt  " + Thread.currentThread().getName());
        }
        System.out.println("Buffed, ending of task  " + Thread.currentThread().getName());
    }
}
