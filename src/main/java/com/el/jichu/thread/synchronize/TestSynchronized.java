package com.el.jichu.thread.synchronize;

/**
 * @author Roman.Zhang
 * @date 2020/5/7
 * @description: 对象锁
 */
public class TestSynchronized {
    public synchronized void minus() {
        int count = 5;
        for (int i = 0; i < 5; i++) {
            count--;
            System.out.println(Thread.currentThread().getName() + " - " + count);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
    //将synchronized关键字删掉
    //可以看到，结果是交替的，说明线程是交替执行的，说明如果某个线程得到了对象锁，但是另一个线程还是可以访问没有进行同步的方法或者代码。进行了同步的方法（加锁方法）和没有进行同步的方法（普通方法）是互不影响的，一个线程进入了同步方法，得到了对象锁，其他线程还是可以访问那些没有同步的方法（普通方法）。当获取到与对象关联的内置锁时，并不能阻止其他线程访问该对象，当某个线程获得对象的锁之后，只能阻止其他线程获得同一个锁。
    public  void minus2() {
        int count = 5;
        for (int i = 0; i < 5; i++) {
            count--;
            System.out.println(Thread.currentThread().getName() + " - " + count);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}
