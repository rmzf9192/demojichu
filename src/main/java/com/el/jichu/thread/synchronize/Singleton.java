package com.el.jichu.thread.synchronize;

public class Singleton {

    private static volatile Singleton singleton;

    private static volatile  boolean flag;

    public Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    return new Singleton();
                }
            }
        }
        return singleton;
    }

    private void run(){
        new Thread(new Runnable(){
            public void run(){
                while(flag){
                    doSomeString();
                }
            }

            private void doSomeString() {
            }
        });
    }

    private void stop(){
        flag=false;
    }


}
