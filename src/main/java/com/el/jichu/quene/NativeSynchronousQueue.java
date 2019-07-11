package com.el.jichu.quene;

/**
 * @author Roman.zhang
 * @Date: 2019/6/28 14:32
 * @Version:V1.0
 * @Description:NativeSynchronousQueue
 */
public class NativeSynchronousQueue<E extends Integer> {
    boolean putting = false;
    E item = null;

    public synchronized E take() throws InterruptedException {
        while (item == null){
            System.out.println("take等待状态");
            wait();
        }
        E e = item;
        item = null;
        notifyAll();
        System.out.println("take执行了唤醒功能");
        return e;
    }
    public synchronized  void put(E e) throws InterruptedException {
        if(e == null){
            return;
        }
        while(putting) {
            System.out.println("put处于等待1");
            wait();
        }
        putting = true;
        item = e;
        notifyAll();
        System.out.println("put执行了唤醒功能1");

        while(item!=null) {
            System.out.println("put处于等待状态2");
            wait();
        }

        putting = false;
        notifyAll();
        System.out.println("put执行了唤醒功能2");
    }

    public static void main(String[] args) throws InterruptedException {
        NativeSynchronousQueue<Integer> nativeSynchronousQueue = new NativeSynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println( nativeSynchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();


        new Thread(()->{
            try {
                nativeSynchronousQueue.put(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BB").start();

    }
}
