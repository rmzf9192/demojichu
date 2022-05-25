package com.el.jichu.thread.transmit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyThread implements Runnable {
    private Work work;

    public MyThread(Work work) {
        this.work = work;
    }

    @Override
    public void run() {
        Random random = new Random();
        int i = random.nextInt(1000);
        int i1 = random.nextInt(2000);
        int i2 = random.nextInt(3000);
        Data data = new Data();
        List<Integer> arrayList = Arrays.asList(i, i1, i2);
        work.process1(data, i, i1, i2);//使用回调函数
        System.out.println(String.valueOf(i) + "+" + String.valueOf(i1) + "+"
                + String.valueOf(i2) + "=" + data.value);
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread(new Work()));
        thread.start();
    }
}
