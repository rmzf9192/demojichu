package com.el.jichu.thread.communication;


import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.*;


public class JoinTest {

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println(Thread.currentThread().getName() + "-》正在运行");
        //countDownLatch();
        join();
        System.out.println(Thread.currentThread().getName() + "：获取当前主线程线程状态：" + Thread.currentThread().getState());
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
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        //等待线程1终止
        t1.join();
        //等待线程2终止
        t2.join();
        System.out.println(Thread.currentThread().getName() + ":获取当前子线程状态：" + Thread.currentThread().getState());

    }

    public static void countDownLatch() throws InterruptedException {
        int thread = 3;
        long start = System.currentTimeMillis();
        final CountDownLatch countDownLatch = new CountDownLatch(thread);

        for (int i = 0; i < thread; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
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

        long end = System.currentTimeMillis();


    }

    private static void cyclicBarrier() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    /**
     * 线程中断通信
     */
    public static class StopThread implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                //线程执行具体的逻辑
                System.out.println(Thread.currentThread().getName() + "线程正在运行");

            }
            System.out.println(Thread.currentThread().getName() + "退出");
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

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        poolExecutor.shutdown();
        while (!poolExecutor.awaitTermination(1, TimeUnit.SECONDS)) {
        }


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

                int msg = 0;
                try {
                    while ((msg = pipedReader.read()) != -1) {
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
