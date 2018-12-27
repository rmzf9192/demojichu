package com.el.jichu.thread.thread;

public class ThreadTest {


    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName()+"-runing");
        for(int i=0;i<10;i++){
            new Thread("name-"+i){
                public void run(){
                    System.out.println("Thread "+getName()+"-runing");
                }
            }.start();
        }
    }
}
