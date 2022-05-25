package com.el.jichu.thread.waitsleep;

public class MyThread implements Runnable {
    private String name;
    private Object prev;
    private Object self;

    public MyThread(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    for(int i=0;i<10;i++){
                        System.out.print(name);
                        count--;
                    }
                    System.out.println();
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Thread a1 = new Thread(new MyThread("A", c, a));
        Thread b1 = new Thread(new MyThread("B", a, b));
        Thread c1 = new Thread(new MyThread("C", b, c));

        a1.start();
        a1.sleep(100);
        b1.start();
        b1.sleep(100);
        c1.start();
        c1.sleep(100);


    }
}
