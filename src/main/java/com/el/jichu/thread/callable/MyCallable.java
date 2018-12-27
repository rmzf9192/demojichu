package com.el.jichu.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable {
    private int i=0;

    public static void main(String[] args){
        Callable<Integer> callable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+",,,"+i);
            if(i==3) {
                Thread thread = new Thread(futureTask);
                thread.start();
            }
        }

        try {
            Integer integer = futureTask.get();//取得新创建的新线程中的call()方法返回的结果

            System.out.println("sum="+integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Object call() throws Exception {
        int sum=0;
        for (;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"->"+i);
            sum+=i;
        }

        return sum;
    }


}
