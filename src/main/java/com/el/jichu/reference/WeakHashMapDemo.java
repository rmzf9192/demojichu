package com.el.jichu.reference;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @Auther: roman.zhang
 * @Date: 2019/6/24 15:25
 * @Version:V1.0
 * @Description:WeakHashMapDemo
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        hashMapTest();
        System.out.println("============");
        weakHashMapTest();
    }

    public static void hashMapTest(){
        HashMap<Object, Object> hashMap = new HashMap<>();

        Integer integer = new Integer(1);

        String value="hashMap";

        hashMap.put(integer,value);
        System.out.println(hashMap);
        integer = null;
        System.out.println(hashMap);
        System.gc();
        System.out.println(hashMap);
    }
    public static void weakHashMapTest(){
        WeakHashMap<Object, Object> hashMap = new WeakHashMap<>();

        Integer integer = new Integer(2);

        String value="hashMap";

        hashMap.put(integer,value);
        System.out.println(hashMap);
        integer = null;
        System.out.println(hashMap);
        System.gc();
        System.out.println(hashMap);
    }
}
