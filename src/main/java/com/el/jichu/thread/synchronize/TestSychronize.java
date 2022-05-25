package com.el.jichu.thread.synchronize;

public class TestSychronize {
    public static void main(String[] args) {
        synchronized (TestSychronize.class) {
            System.out.println("TestSychronize");
        }
    }
}
