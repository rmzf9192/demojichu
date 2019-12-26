package com.el.jichu.thread.threadlocal;

/**
 * @author roman zhangfei
 * @Date 2019/10/17 15:53
 * @Version V1.0
 */
public class MyThreadLocal {
    static class MyThread extends Thread{
        private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 3; i++) {
                System.out.println("init value:"+threadLocal.get());
                threadLocal.set(i);
                System.out.println(getName()+"-threadLocal get()=" +threadLocal.get());
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new MyThread();
        Thread thread1 = new MyThread();
        thread.setName("ThreadA");
        thread1.setName("ThreadB");

        thread.start();
        thread1.start();

    }
}
