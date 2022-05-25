package com.el.jichu.thread.dielock;

import java.util.concurrent.TimeUnit;

/**
 * 哲学家
 */
public class Chopstick {

    private boolean taken = false;

    //拿起筷子
    public synchronized void taken() throws InterruptedException {
        while (taken) {
            //为true时，拿起筷子
            wait();
        }
        TimeUnit.SECONDS.sleep(10);
        taken = true;
    }

    //放下筷子
    public synchronized void drop() {
        taken = false;
        notify();
    }
}
