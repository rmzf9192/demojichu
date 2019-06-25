package com.el.jichu.collection.list;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/15 20:00
 * @Version:V1.0
 * @Description:ContainerSetNotSafeDemo
 */
public class ContainerSetNotSafeDemo {
    public static void main(String[] args) {
        Set<String> hashSet = new CopyOnWriteArraySet<>();

        for(int i=1;i<30;i++){
            new Thread(()->{
                hashSet.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(hashSet);
            },String.valueOf(i)).start();
        }
        new HashSet<>().add("a");
    }
}
