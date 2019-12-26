package com.el.jichu.thread.future;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author roman zhangfei
 * @Date 2019/10/29 10:34
 * @Version V1.0
 */
public class FutureDemo {
    public static void main(String[] args) {
        Instant start = Instant.now();
        ExecutorService executor = Executors.newCachedThreadPool();

        Future future = executor.submit(()->{
            System.out.println("子线程正在执行");
            int sum =1;
            Thread.sleep(3000);
            for (int i = 0; i < 100; i++) {
                sum= sum+i;
            }
            return sum;
        });

        Instant mid = Instant.now();
        System.out.println("拿到Future 执行mid结果："+ Duration.between(start,mid).toMillis());

        try {
            System.out.println("执行结果："+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        Instant end = Instant.now();
        System.out.println("拿到Future 执行end结果："+ Duration.between(start,end).toMillis());
    }
}
