package com.el.jichu.collection.list;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/15 20:03
 * @Version:V1.0
 * @Description:ContainerMapNotSafeDemo
 */
public class ContainerMapNotSafeDemo {
    public static void main(String[] args) {
        Map<String,Object> hashSet = new ConcurrentHashMap<>();

        for(int i=1;i<30;i++){
            new Thread(()->{
                hashSet.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(hashSet);
            },String.valueOf(i)).start();
        }
    }
}
