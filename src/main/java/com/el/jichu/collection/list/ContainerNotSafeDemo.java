package com.el.jichu.collection.list;

import lombok.val;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/14 21:33
 * @Version:V1.0
 * @Description:ContainerNotSafeDemo
 *   集合类不安全问题
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
//        List<String> lists=Arrays.asList("a","b","c","d");
//        List<String> lists=new ArrayList<>();
//        List<String> lists=new Vector<>();
//        List<String> lists=Collections.synchronizedList(new ArrayList<>());
        List<String> lists=new CopyOnWriteArrayList<>();
        /**
         * Collection:
         * Collections:
         */
        for (int i = 0; i <30 ; i++) {
            new Thread(()->{
                lists.add(UUID.randomUUID().toString().substring(0,8));
//                lists.forEach(System.out::println);
                System.out.println(Thread.currentThread().getName()+":"+lists);
            },String.valueOf(i)).start();
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Iterator<String> iterator = lists.iterator();
        while (iterator.hasNext()){
            boolean remove = lists.remove(iterator.next());
            System.out.println(remove);
        }
        lists.forEach(System.out::println);
    }
    //java.util.ConcurrentModificationException
    /**
     *  不要只是会用，会用只不过是一个API调用工程师
     *   底层原理？？
     * 1.故障现象
     *    java.util.ConcurrentModificationException
     *
     * 2.导致原因
     *    并发争抢修改导致，参考我们的花名册签名情况。
     *    一个人正在写入，另外一个同学过来抢夺，导致数据不一致异常，并发修改异常
     * 3.解决方案
     *   3.1 Vector
     *   3.2 Collections.synchronizedList(new ArrayList<>());
     *   3.3 new CopyOnWriteArrayList()
     * 4.优化建议
     */
}
