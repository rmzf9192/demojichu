package com.el.jichu.thread.dielock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Philosoper implements Runnable {
    private Chopstick right;
    private Chopstick left;
    private final int id;
    private int eatTime;
    private int thinkTime;
    private Random random = new Random(42);

    public Philosoper(Chopstick right, Chopstick left, int id, int eatTime, int thinkTime) {
        this.right = right;
        this.left = left;
        this.id = id;
        this.eatTime = eatTime;
        this.thinkTime = thinkTime;
    }

    //吃饭或者思考的时间
    public void pause(int time) {
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(time * 2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(this + "thinking");
                pause(thinkTime);
                //开始吃饭
                System.out.println(this + "left");
                left.taken();
                System.out.println(this + "right");
                right.taken();
                System.out.println(this + "eating");
                pause(eatTime);

                //吃完饭，放下筷子
                left.drop();
                right.drop();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Philosoper{" +
                "id=" + id +
                '}';
    }
}
