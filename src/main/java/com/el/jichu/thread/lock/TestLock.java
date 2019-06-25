package com.el.jichu.thread.lock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    private ReentrantLock lock = new ReentrantLock();
    private Map<String, Integer> map = new ConcurrentHashMap();

    public void run() throws InterruptedException {

        lock.lock();
        try {
            //do bussiness
        } finally {
            lock.unlock();
        }
    }
}
