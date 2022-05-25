package com.el.jichu;

import lombok.val;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 功能说明
 * </p >
 *
 * @author Roman.Zhang
 * @date 2020/10/19
 */
public class Test1 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));
        int taskNum = 13;
        for (int i = 0; i < taskNum; i++) {
            final int finalI = i;
            if (i == 10) {
                System.out.println("执行过10个任务，开始空闲");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("提交任务：" + (i + 1));
            executor.submit(new Runnable() {
                public void run() {
                    Integer taskNum = finalI + 1;
                    System.out.println("task: " + taskNum + ", " + Thread.currentThread().getName() + ", " + System.currentTimeMillis());
                }
            });
        }


        val corePoolSize = executor.getCorePoolSize();
        System.out.println("核心线程数："+corePoolSize);
        System.out.println("最大线程数："+executor.getMaximumPoolSize());
        System.out.println("活跃线程数："+executor.getActiveCount());
        System.out.println("拒绝策略："+executor.getRejectedExecutionHandler());
        System.out.println("任务数："+executor.getTaskCount());
        executor.getQueue().forEach(v-> System.out.println(v));

        executor.shutdownNow();
//
        int i  = 10;
        for (;;) {
            Byte[] by = new Byte[1024 * 1024 ];
            System.out.println(by);
//            System.out.println(SingletonDemo1.getBy());
//            System.out.println(SingletonDemo1.getBy().length);
//            by = null;

        }
//        String s= "hhhd";
//        for (String s1 : s.split(",")) {
//            System.out.println(s1);
//        }
//        String str="d:/123/456/789.txt";
//        System.out.println(str.substring(str.lastIndexOf("/")+1,str.length()));
//        System.out.println(300%144);
//        System.out.println(300/144);
//        Inter2 interface1 = new Inter2();
////        Interface1 interface1 = new Inter();
//
//        int i = 10;
//        int i1 = 20;
//        byte b = 123;
//        Inter2 inter2;
//        interface1.jiao();
//        System.out.println(i1);
//        List<Byte[]> byteList = new ArrayList<Byte[]>();
//        for(;;){
//            Byte[] bytes = new Byte[1024 * 1024 * 10];
//            byteList.add(bytes);
//        }
    }
}
