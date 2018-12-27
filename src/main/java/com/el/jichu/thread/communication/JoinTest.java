package com.el.jichu.thread.communication;


import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.*;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println(Thread.currentThread().getName()+"-》正在运行");
        //countDownLatch();
        join();
        System.out.println(Thread.currentThread().getName()+"：获取当前主线程线程状态："+Thread.currentThread().getState());
        // cyclicBarrier();
       /* Thread thread = new Thread(new StopThread(), "Thread-A");

        thread.start();

        System.out.println("main主线程正在运行");
        TimeUnit.MICROSECONDS.sleep(10);
        thread.interrupt();*/

       // executorService();

        //piped();
    }

    public static void join() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("running1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }) ;
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("running2");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }) ;

        t1.start();
        t2.start();

        //等待线程1终止
        t1.join();
        //等待线程2终止
        t2.join();
        System.out.println(Thread.currentThread().getName()+":获取当前子线程状态："+Thread.currentThread().getState());
        LOGGER.info("main over");

    }

    public static void countDownLatch() throws InterruptedException {
        int thread=3;
        long start=System.currentTimeMillis();
        final CountDownLatch countDownLatch = new CountDownLatch(thread);

        for(int i=0;i<thread;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    LOGGER.info("线程正在runing");
                    try {
                        Thread.sleep(3000);
                        countDownLatch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        countDownLatch.await();

        long end=System.currentTimeMillis();


      LOGGER.info("main over total time={}："+(end-start));
    }

    private static void cyclicBarrier(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                LOGGER.info(Thread.currentThread().getName()+"Thread Runing");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                LOGGER.info("Thread end do something");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                LOGGER.info(Thread.currentThread().getName()+"Thread Running");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                LOGGER.info("Thread end do something");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                LOGGER.info(Thread.currentThread().getName()+"Thread Running");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                LOGGER.info("Thread end do something");
            }
        }).start();

        LOGGER.info("main thread");

    }

    /**
     * 线程中断通信
     */
    public static class StopThread implements Runnable{

        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()){
                //线程执行具体的逻辑
                System.out.println(Thread.currentThread().getName()+"线程正在运行");

            }
            System.out.println(Thread.currentThread().getName()+"退出");
        }
    }

    /**
     * 线程池 awaitTermination() 方法
     */
    public static void executorService() throws InterruptedException {
        BlockingDeque<Runnable> objects = new LinkedBlockingDeque<>(10);

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MILLISECONDS, objects);

        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                LOGGER.info(Thread.currentThread().getName()+"-runing");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                LOGGER.info(Thread.currentThread().getName()+"-runing");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        poolExecutor.shutdown();
        while(!poolExecutor.awaitTermination(1,TimeUnit.SECONDS)){
            LOGGER.info("线程还在执行");
        }

        LOGGER.info("main over");

    }

    /**
     * 管道通信
     */
    public static void piped() throws IOException {
        //面向于字符 PipedInputStream 面向于字节

        PipedWriter pipedWriter = new PipedWriter();
        PipedReader pipedReader = new PipedReader();

        //输入输出流建立连接
        pipedWriter.connect(pipedReader);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                LOGGER.info(Thread.currentThread().getName() + "-runing");
                try {
                    for (int i = 0; i < 10; i++) {
                        pipedWriter.write(i + "");
                        Thread.sleep(10);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        pipedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                LOGGER.info(Thread.currentThread().getName() + "-runing");

                int msg = 0;
                try {
                    while ((msg = pipedReader.read()) != -1) {
                        LOGGER.info(Thread.currentThread().getName() + "-msg{}=" + (char) msg);
                    }
                } catch (Exception e) {

                }
            }
        });
        thread1.start();
        thread2.start();
        System.out.println("main over");
    }
}
