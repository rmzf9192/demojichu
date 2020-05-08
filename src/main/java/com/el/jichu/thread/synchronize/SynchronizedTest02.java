package com.el.jichu.thread.synchronize;

/**
 * @author Roman.Zhang
 * @date 2020/5/7
 * @description: 类锁测试
 *  可以看到，类锁和对象锁其实是一样的，由于静态方法是类所有对象共用的，所以进行同步后，该静态方法的锁也是所有对象唯一的。每次只能有一个线程来访问对象的该非静态同步方法
 * */
public class SynchronizedTest02 {
    public static void main(String[] args) {
        final TestSynchronized02 test = new TestSynchronized02();
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                TestSynchronized02.minus();
            }
        });

        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                test.minus2(); //调用对象锁：可以看到两个线程是交替进行的，也就是说类锁和对象锁是不一样的锁，是互相独立的。
            }
        });

        thread1.start();
        thread2.start();

    }


}
