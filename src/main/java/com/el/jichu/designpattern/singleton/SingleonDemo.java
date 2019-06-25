package com.el.jichu.designpattern.singleton;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/14 13:32
 * @Version:V1.0
 * @Description:SingleonDemo
 */
public class SingleonDemo {
    private static SingleonDemo instance=null;
    public SingleonDemo(){
        System.out.println(Thread.currentThread().getName()+"\t 我是构造方法的SingleonDemo()");
    }

    //DCL Double Check Lock双端检锁机制
    public static SingleonDemo getInstance(){
        if(instance==null){
            synchronized (SingleonDemo.class){
                if(instance==null){
                    instance=new SingleonDemo();
                }
            }

        }
        return instance;
    }

    public static synchronized SingleonDemo getInstance1(){
        if(instance==null){
                    instance=new SingleonDemo();
            }

        return instance;
    }

    public static void main(String[] args) {
      /*  //单线程
        System.out.println(SingleonDemo.getInstance());
        System.out.println(SingleonDemo.getInstance());
        System.out.println(SingleonDemo.getInstance());*/
        //并发多线程
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                SingleonDemo.getInstance();
            },String.valueOf(i)).start();

        }
    }
}
