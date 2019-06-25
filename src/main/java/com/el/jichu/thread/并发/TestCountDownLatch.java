package com.el.jichu.thread.并发;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/22 16:28
 * @Version:V1.0
 * @Description:TestCountDownLatch CountDownLatch ：闭锁，在完成某些运算是，只有其他所有线程的运算全部完成，当前运算才继续执行
 */
public class TestCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(50);
        Lath lath = new Lath(countDownLatch);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            new Thread(lath, "a" + i).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        System.out.println("耗费的时间：" + (end - start));

    }
}

class Lath implements Runnable {
    private CountDownLatch countDownLatch;

    public Lath(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5000; i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "i=" + i);
                }
            }
        } finally {
            countDownLatch.countDown();
        }
    }
}
