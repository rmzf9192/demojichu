package com.el.jichu.thread.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author roman zhangfei
 * @Date 2019/10/29 11:29
 * @Version V1.0
 */
public class ForkJoinDemo {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        Fibonacci task = new Fibonacci(6);
        int ans = pool.invoke(task);
        System.out.println(ans);

    }

    static class Fibonacci extends RecursiveTask<Integer> {
        private int n;
        public Fibonacci(int n) {
            this.n = n;
        }
        @Override
        protected Integer compute() {
            System.out.println(Thread.currentThread().getName());
            if(n <= 2) {
                return 1;
            }
            try{
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Fibonacci f1 = new Fibonacci(n - 1);
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            f2.fork();
            int ans = f1.join() + f2.join();
            return ans;
        }
    }

}
