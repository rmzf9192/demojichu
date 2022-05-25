package com.el.jichu.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @Auther: roman.zhang
 * @Date: 2019/6/24 15:01
 * @Version:V1.0
 * @Description:ReferenceQueueDemo
 */
public class ReferenceQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();

        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();

        WeakReference<Object> weakReference = new WeakReference<>(o, referenceQueue);

        System.out.println(o);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());


        System.out.println("======================");
        o = null;
        System.gc();
        Thread.sleep(500);

        System.out.println(o);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
    }
}


