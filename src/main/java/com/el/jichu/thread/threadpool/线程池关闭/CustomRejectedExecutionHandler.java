package com.el.jichu.thread.threadpool.线程池关闭;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/26 15:23
 * @Version:V1.0
 * @Description:CustomRejectedExecutionHandler
 */
public class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {
            executor.getQueue().put(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
