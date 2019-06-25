package com.el.jichu.reference;

import java.lang.ref.SoftReference;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/27 10:27
 * @Version:V1.0
 * @Description:SoftReferenceDeom
 */
public class SoftReferenceDeom {
    public static void softRef_Enough(){
        Object o = new Object();
        SoftReference<Object> objectSoftReference = new SoftReference<>(o);
        System.out.println(o);
        System.out.println(objectSoftReference.get());
        o=null;
        System.gc();
        System.out.println(o);
        System.out.println(objectSoftReference.get());
    }
    public static void softRef_NotEnough(){
        Object o = new Object();
        SoftReference<Object> objectSoftReference = new SoftReference<>(o);
        System.out.println(o);
        System.out.println(objectSoftReference.get());
        o=null;
        System.gc();
        try {
            byte[] bytes = new byte[30 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(o);
            System.out.println(objectSoftReference.get());
        }

    }
    public static void main(String[] args) {
//        softRef_NotEnough();
        softRef_Enough();
    }
}
