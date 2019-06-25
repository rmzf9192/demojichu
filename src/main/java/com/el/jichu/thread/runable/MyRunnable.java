package com.el.jichu.thread.runable;

public class MyRunnable implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        for (i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + ",,," + i);
        }
    }

    public static void main(String[] agrs) {
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + ",,,," + i);
            Thread.currentThread().setPriority(1);
            MyRunnable myRunnable = new MyRunnable();
            Thread thread = new Thread(myRunnable, "Thread-A");
            thread.setPriority(1);
            Thread thread1 = new Thread(myRunnable, "Thread-B");
            thread1.setPriority(10);

            thread.start();
            thread1.start();
        }
    }
}
