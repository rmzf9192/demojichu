package com.el.jichu.jvm;

/**
 * @Auther: roman.zhang
 * @Date: 2019/6/24 16:51
 * @Version:V1.0
 * @Description:UnableCreateThreadDemo
 */
public class UnableCreateThreadDemo {
    public static void main(String[] args) {
        for (int i = 0; ; i++) {
            System.out.println("******************i="+i);
            new Thread(()->{
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, ""+i).start();
        }
    }
}
