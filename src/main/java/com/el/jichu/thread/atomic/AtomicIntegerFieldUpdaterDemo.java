package com.el.jichu.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author roman zhangfei
 * @Date 2019/10/25 9:47
 * @Version V1.0
 */
public class AtomicIntegerFieldUpdaterDemo {

    public static class Candidate{
        int id;
        volatile int score;
    }

    /**
     * 使用反射获取score
     */
    public final static AtomicIntegerFieldUpdater updataScore =
            AtomicIntegerFieldUpdater.newUpdater(Candidate.class,"score");

    public static AtomicInteger allScore = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final Candidate candidate = new Candidate();

        Thread[] t = new Thread[10000];

        for (int i = 0; i < 10000; i++) {
            t[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    updataScore.incrementAndGet(candidate);
                    allScore.incrementAndGet();
                }
            });

            t[i].start();
        }

        for (int i = 0; i < 10000; i++) {
            t[i].join();
        }

        System.out.println("score = "+candidate.score);
        System.out.println("allScore ="+allScore);


    }
}
