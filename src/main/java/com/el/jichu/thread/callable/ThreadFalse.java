package com.el.jichu.thread.callable;

public class ThreadFalse {

    public static void main(String[] args) {
        MyRunable myRunable = new MyRunable();
        Thread thread = new Thread(myRunable, "Thread-A");

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "->" + i);
            if (i == 30) {
                thread.start();
            }
            if (i == 40) {
                myRunable.stopThread();
            }
        }
    }


    public static class MyRunable implements Runnable {
        private boolean flag = true;

        @Override
        public void run() {
            for (int i = 0; i < 100 && flag; i++) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
        }

        public void stopThread() {
            flag = false;
        }
    }

}
