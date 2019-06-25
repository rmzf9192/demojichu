package com.el.jichu.thread.dielock;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockingDiningPhiosophers {
    private static final int N = 3;
    private static final int eatTime = 20;
    private static final int thinkTime = 3;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Chopstick[] chopsticks = new Chopstick[N];
        for (int i = 0; i < N; i++) {
            chopsticks[i] = new Chopstick();
        }

        for (int i = 0; i < N; i++) {
            executorService.execute(new Philosoper(chopsticks[i], chopsticks[(i + 1) % N], i, eatTime, thinkTime));
        }
    }

}
