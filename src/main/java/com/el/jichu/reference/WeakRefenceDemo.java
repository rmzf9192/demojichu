package com.el.jichu.reference;

import java.io.ObjectInputStream;
import java.lang.ref.WeakReference;

/**
 * @Auther: roman.zhang
 * @Date: 2019/6/24 14:55
 * @Version:V1.0
 * @Description:WeakRefenceDemo
 */
public class WeakRefenceDemo {

    public static void main(String[] args) {
        Object obj1 = new Object();

        WeakReference w = new WeakReference(obj1);
        System.out.println(obj1);
        System.out.println(w.get());

        obj1 =  null;
        System.gc();

        System.out.println("====================");
        System.out.println(obj1);
        System.out.println(w.get());
    }
}
