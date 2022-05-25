package com.el.jichu.thread.thread;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    private static int i = 0;

    public  void run() {
        for (i = 0; i < 300; i++) {
            i+=1;
            Test.person.setName("ceshi"+i);
            System.out.println(Thread.currentThread().getName() + "    " + i +",person名称"+Test.person.getName());
        }

        System.out.println("执行完之后的线程："+Thread.currentThread().getName() + "    " + i +",person名称"+Test.person.getName());
    }

    public static void main(String[] args) {

        for (int i = 0; i < 1; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
            MyThread thread1 = new MyThread("Thtrea-A");

            MyThread thread2 = new MyThread("Thtrea-B");

            Test.person.setName("我的为主");
            thread1.start();
            thread2.start();
        }

    }
}
