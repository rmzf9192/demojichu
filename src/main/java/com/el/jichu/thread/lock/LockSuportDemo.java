package com.el.jichu.thread.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author roman zhangfei
 * @Date 2019/10/18 11:12
 * @Version V1.0
 */
public class LockSuportDemo extends Thread {
    private Object object;

    public LockSuportDemo(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        System.out.println("before unpark");

        try{
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("Broker info "+ LockSupport.getBlocker((Thread)object));

//        LockSupport.unpark((Thread) object);

        Thread thread = (Thread) object;
        thread.interrupt();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(Thread.currentThread().isInterrupted());

        }

        System.out.println("Broker info "+ LockSupport.getBlocker((Thread)object));

        System.out.println("after unpark");
    }

    public static void main(String[] args) {
        LockSuportDemo demo = new LockSuportDemo(Thread.currentThread());

        demo.start();

        System.out.println("before park");

        LockSupport.park("ParkAndUnParkDemo");

        System.out.println("after park");
    }
}
