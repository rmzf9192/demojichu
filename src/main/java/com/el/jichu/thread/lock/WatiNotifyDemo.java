package com.el.jichu.thread.lock;

/**
 * @author roman zhangfei
 * @Date 2019/10/18 11:02
 * @Version V1.0
 */
public class WatiNotifyDemo extends Thread {
    @Override
    public void run() {
        synchronized (this){
            System.out.println("before notify");
            notify();
            System.out.println("after notify");
        }
    }

    public static void main(String[] args) {
        WatiNotifyDemo watiNotifyDemo = new WatiNotifyDemo();

        synchronized (watiNotifyDemo){
            try {
                watiNotifyDemo.start();
                //主线程睡3秒
                Thread.sleep(3000);
                System.out.println("before wait");
                watiNotifyDemo.wait();
                System.out.println("after wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
