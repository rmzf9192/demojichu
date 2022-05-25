package com.el.jichu.thread.lock;

public class MyThread extends Thread {
    private InterruptLockTest test;

    public MyThread(InterruptLockTest test) {
        this.test = test;
    }

    @Override
    public void run() {
        try {
            test.test(Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
