package com.el.jichu.io.netty.heartbeat;

/**
 * @author roman zhangfei
 * @Date 2019/12/31 14:34
 * @Version V1.0
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.nanoTime()); //纳秒  10亿分之1
        Thread.sleep(1000);
        System.out.println(System.nanoTime());
    }
}