package com.el.jichu.thread.communication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

    private IntGenerator intGenerator;

    public EvenChecker(IntGenerator intGenerator) {
        this.intGenerator = intGenerator;
    }

    @Override
    public void run() {
     int val=0;
     while(!intGenerator.isCanceled()){
         val= intGenerator.next();
         if(val%2!=0){
             System.out.println("Error info --->" + val + " not even, threadInfo=" + Thread.currentThread().getName());
             intGenerator.cancel();
         }
     }
    }
    public static void test(IntGenerator gp, int count){
        System.out.println("start test " + count + "  thread") ;
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<count;i++){
            exec.execute(new EvenChecker(gp));
        }
    }

    public static void test(IntGenerator gp){
        test(gp,5);
    }

    public static void main(String[] args) {
        test(new IntGenerator());
    }
}
