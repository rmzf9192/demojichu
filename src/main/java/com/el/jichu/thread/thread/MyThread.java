package com.el.jichu.thread.thread;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    private int i = 0;

    public void run() {
        for (i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + "    " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
            MyThread thread1 = new MyThread("Thtrea-A");

            MyThread thread2 = new MyThread("Thtrea-B");

            thread1.start();
            thread2.start();

        }

    }
}
