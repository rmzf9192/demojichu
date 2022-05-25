package com.el.jichu.thread.future;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @author roman zhangfei
 * @Date 2019/10/28 11:56
 * @Version V1.0
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws InterruptedException {
        String join = CompletableFuture.supplyAsync(() -> {
            return "hello";
        }).thenApplyAsync(v -> v + " world").join();

        System.out.println(join);


        System.out.println("start time :"+ Instant.now());

        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("开始耗时计算:" + Instant.now());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束耗时计算:" + Instant.now());
            return 101;
        });

        integerCompletableFuture.whenComplete((result,i)->{
            System.out.println("回调结果:" + result);
        });

        System.out.println("end time :"+ Instant.now());

        new CountDownLatch(1).await();
    }
}
