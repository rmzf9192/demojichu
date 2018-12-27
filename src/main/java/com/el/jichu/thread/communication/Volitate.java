package com.el.jichu.thread.communication;

import java.util.concurrent.TimeUnit;

public class Volitate implements Runnable {
    private static volatile boolean flag=true;
    @Override
    public void run() {

        while (flag){
            System.out.println(Thread.currentThread().getName()+"正在运行。。。");
        }
        System.out.println(Thread.currentThread().getName()+"执行结束");
    }
    public static void main(String[] args) throws InterruptedException {
        Volitate volitate = new Volitate();
        new Thread(volitate,"Thread-A").start();

        System.out.println("主线程正在运行");

        TimeUnit.MICROSECONDS.sleep(1000);
        volitate.stopThread();
    }
    private void stopThread(){
        flag=false;
    }


}
