package com.el.jichu.thread.communication;

import javax.management.relation.RoleUnresolved;
import java.util.concurrent.TimeUnit;

/**
 * 执行涂蜡任务
 */
public class WaxOn implements Runnable {

    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                //开始涂蜡
                System.out.println("WaxOn:开始涂蜡-》" + Thread.currentThread().getName());
                //模拟涂蜡的时间
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxOn();
                car.waitWBuffed();
            }
        } catch (InterruptedException e) {
            System.out.println("WaxOn, exiting via interrupt  " + Thread.currentThread().getName());
        }
        System.out.println("WaxOn, ending of task  " + Thread.currentThread().getName());
    }
}
