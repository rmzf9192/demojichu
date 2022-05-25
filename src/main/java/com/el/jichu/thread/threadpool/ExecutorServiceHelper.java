package com.el.jichu.thread.threadpool;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServiceHelper {
    /**
     * 获取活跃的CPU的数量
     */
    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private static final BlockingQueue<Runnable> mWorkQueue;
    private static final long KEEP_ALIVE_TIME = 60L;
    private static final TimeUnit KEEP_ALIVE_TIME_UTIL = TimeUnit.SECONDS;
    private static final ThreadFactory mThreadFactory;

    static {
        //mWorkQueue=new LinkedBlockingQueue<>();
        mWorkQueue = new ArrayBlockingQueue<>(3);
        //默认的工厂方法将新创建的线程命名为：pool-[虚拟机中线程池编号]-thread-[线程编号]
        //threadFactory = Executors.defaultThreadFactory();
        mThreadFactory = new NamedThreadFactory();
        System.out.println("NUMBER_OF_CORES:" + NUMBER_OF_CORES);
        System.out.println("KEEP_ALIVE_TIME:" + KEEP_ALIVE_TIME);
        System.out.println("KEEP_ALIVE_TIME_UTIL:" + KEEP_ALIVE_TIME_UTIL);

    }

    public static void execute(Runnable runnable) {
        if (runnable == null) return;

        /**
         * 1.线程池小于corePoolSize时，新提交任务将创建一个新的线程执行任务，即使此时线程池中存在空闲线程
         * 2.当线程池达到corePoolSize时，新提交任务将被放入到workQueue中，等待线程池任务调度执行
         * 3.当workQueue队列满，且maximumPoolSize>corePoolSize时，新提交任务会创建新的线程执行任务
         * 4.当提交任务数大于maximunPoolSize时，新提交任务将由RejectedExecutionHandle处理
         * 5.当线程池中超过corePoolSize时，空闲时间达到keepAliveTime，关闭空闲线程
         * 6.当设置allowCoreThreadTimeOut(true)时，线程池中corePoolSize空闲时间达到keepAliveTime,也将关闭
         *   maximumPoolSize推荐值：
         *    如果是CPU密集型任务，就需要压榨CPU,参考值可以是NUMBER_OF_CORES+1，或NUMBER_OF_CORES+2；
         *    如果是IO密集型任务，参考值可以是NUMBER_OF_CORES*2；
         *
         */
        ExecutorService executorService = new ThreadPoolExecutor(NUMBER_OF_CORES, NUMBER_OF_CORES + 2, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UTIL,
                mWorkQueue, mThreadFactory);
        executorService.execute(runnable);
    }

    private static class NamedThreadFactory implements ThreadFactory {
        private final AtomicInteger threadNumberAtomicInteger = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, String.format(Locale.CHINA, "%s%d", "NamedThreadFactory", threadNumberAtomicInteger.getAndIncrement()));
           /* thread.setDaemon(true);//是否是守护线程
            thread.setPriority(Thread.NORM_PRIORITY);//设置优先级 1~10 有3个常量 默认 Thread.MIN_PRIORITY*/
            return thread;
        }
    }

    public static void main(String[] args) {
      /*  ExecutorServiceHelper.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("输出内容");
            }
        });*/


        MyTask task1 = new MyTask(1, "task1");
        MyTask task2 = new MyTask(2, "task2");
        MyTask task3 = new MyTask(3, "task3");
        MyTask task4 = new MyTask(4, "task4");
        MyTask task5 = new MyTask(5, "task5");
        MyTask task6 = new MyTask(6, "task6");
        MyTask task7 = new MyTask(7, "task7");
        MyTask task8 = new MyTask(8, "task8");
        MyTask task9 = new MyTask(9, "task9");
        MyTask task10 = new MyTask(10, "task10");
        MyTask task11 = new MyTask(11, "task11");
        MyTask task12 = new MyTask(12, "task12");
        ExecutorServiceHelper.execute(task1);
        ExecutorServiceHelper.execute(task2);
        ExecutorServiceHelper.execute(task3);
        ExecutorServiceHelper.execute(task4);
        ExecutorServiceHelper.execute(task5);
        ExecutorServiceHelper.execute(task6);
        ExecutorServiceHelper.execute(task7);
        ExecutorServiceHelper.execute(task8);
        ExecutorServiceHelper.execute(task9);
        ExecutorServiceHelper.execute(task10);
        ExecutorServiceHelper.execute(task11);
        ExecutorServiceHelper.execute(task12);


    }
}
