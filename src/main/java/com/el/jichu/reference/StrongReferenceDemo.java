package com.el.jichu.reference;

/**
 * @Auther: roman.zhang
 * @Date: 2019/6/24 14:31
 * @Version:V1.0
 * @Description:StrongReferenceDemo
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object obj1 = new Object();

        Object obj2 = obj1;

        obj1 = null ;
        System.gc();
        System.out.println(obj2);
    }
}
