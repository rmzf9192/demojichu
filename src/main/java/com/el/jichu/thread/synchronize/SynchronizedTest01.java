package com.el.jichu.thread.synchronize;

/**
 * @author Roman.Zhang
 * @date 2020/5/7
 * @description: 对象锁测试
 *  两个线程 thread1 和 thread2，同时访问对象的方法，由于该方法是 synchronized 关键字修饰的，那么这两个线程都需要获得该对象锁，一个获得后另一个线程必须等待。所以我们可以猜测运行结果应该是，一个线程执行完毕后，另一个线程才开始执行
 */
public class SynchronizedTest01 {
    public static void main(String[] args) {

        final TestSynchronized test = new TestSynchronized();

        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                test.minus();
            }
        });

        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                test.minus2();//改为调用minus2方法
            }
        });

        thread1.start();
        thread2.start();

    }
}
