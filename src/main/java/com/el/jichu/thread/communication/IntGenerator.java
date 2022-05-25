package com.el.jichu.thread.communication;

public class IntGenerator {

    private int currentEvenValue = 0;
    private volatile boolean canceled = false;

    public synchronized int next() {
        ++currentEvenValue;
        return ++currentEvenValue;
    }

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
