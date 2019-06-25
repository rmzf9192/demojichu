package com.el.jichu.thread.communication;

public class Car {
    private boolean waxOn = false;//false：代表涂蜡，true:代表抛光

    //涂蜡操作
    public synchronized void waxOn() {
        waxOn = true;//涂蜡涂好了，可以开始抛光了
        notify();
    }

    //抛光操作
    public synchronized void buffed() {
        waxOn = false;
        notify();
    }

    //等到涂蜡
    public synchronized void waitWaxOn() throws InterruptedException {
        while (waxOn == false) {
            wait();
        }
    }

    //等到抛光
    public synchronized void waitWBuffed() throws InterruptedException {
        while (waxOn == true) {
            wait();
        }
    }
}
