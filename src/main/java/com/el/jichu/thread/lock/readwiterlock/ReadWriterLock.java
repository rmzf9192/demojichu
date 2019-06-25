package com.el.jichu.thread.lock.readwiterlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache{
    private volatile Map<String,Object> map=new HashMap<>();
    private ReentrantReadWriteLock rwLock =new ReentrantReadWriteLock();

    public void put(String key,Object value){
      rwLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在写入"+key);
            try{
                TimeUnit.MILLISECONDS.sleep(300);
            }catch (Exception e){
                e.printStackTrace();
            }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }

    }
    public void get(String key){
        rwLock.readLock().lock();
        try{
        System.out.println(Thread.currentThread().getName()+"\t 正在读取");
            try{
                TimeUnit.MILLISECONDS.sleep(300);
            }catch (Exception e){
                e.printStackTrace();
            }
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成"+o);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
    }
    public void clearCache(String key){
        map.remove(key);
    }
}
/**
 * @Auther: roman.zhang
 * @Date: 2019/4/16 19:32
 * @Version:V1.0
 * @Description:ReadWriterLock
 */
public class ReadWriterLock {
    public static void main(String[] args) {
      MyCache cache=new MyCache();

        for (int i = 0; i <5 ; i++) {
            final int tempInt=i;
            new Thread(()->{
                cache.put(tempInt+"",tempInt+"");
            },String.valueOf(i)).start();

        }

        for (int i = 0; i <5 ; i++) {
            final int tempInt=i;
            new Thread(()->{
                cache.get(tempInt+"");
            },String.valueOf(i)).start();

        }
    }
}
