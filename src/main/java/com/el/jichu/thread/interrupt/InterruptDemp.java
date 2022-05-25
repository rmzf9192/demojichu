package com.el.jichu.thread.interrupt;

/**
 * @author roman zhangfei
 * @Date 2019/10/18 13:47
 * @Version V1.0
 */
public class InterruptDemp {

    public static void main(String[] args) throws InterruptedException {

/*
        Thread.sleep(200);

        new Thread(()->{

            Thread thread = Thread.currentThread();
            for (int i = 0; i < 5 & !thread.isInterrupted(); i++) {
                System.out.println("线程："+thread.getName()+" i ="+i+" 状态："+thread.isInterrupted());

                if(i == 3){
                    thread.interrupt();
                    System.out.println("线程："+thread.getName()+" i ="+i+ "状态："+thread.isInterrupted());
                }
            }

            System.out.println("线程："+thread.getName()+"停止");

        }).start();*/

        Thread.sleep(200);
        System.out.println();
        System.out.println("在无阻塞状态(sleep/wait/join)的while循环中应用interrupt()和isInterrupted()");
        Thread thread1 = new Thread(() -> {
            try {
            //如果当前线程没被中断，则一直进行
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("线程[" + Thread.currentThread().getName() + "]正在运行...");
                    Thread.sleep(3000);
            }
            System.out.println("线程[" + Thread.currentThread().getName() + "]停止运行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        Thread.sleep(10);
        thread1.interrupt();

    }

}
