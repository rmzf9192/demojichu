package com.el.jichu.designpattern.singleton;

/**
 * @author Roman.zhang
 * @Date: 2019/7/4 14:24
 * @Version:V1.0
 * @Description:SingleDemo1 单例模式
 */
public class SingleDemo1 {
    // 持有私有静态  ，赋值为null ，目的是实现延迟加载
    private static  SingleDemo1 instance  = null;

    private SingleDemo1(){

    }

    private String SingleDemo1(){
        return "jjj";
    }

    /**
     * 为保证线程安全可以使用synchronized关键字，但是在方法上影响性能。因此
     * @return
     */
    //public static synchronized SingleDemo1 getInstance(){
  /*  public static  SingleDemo1 getInstance(){
        if(null == instance){
            //双端检锁机制
            // 存在的问题
            *//*
            说 instance = new Singleton();语句是分两步执行的。但是 JVM 并不保证这两个操作的先后顺序，
            也就是说有可能 JVM 会为新的 Singleton 实例分配 空间，然后直接赋值给 instance 成员，
            然后再去初始化这个 Singleton 实例。这样就可能出错了
             *//*
            synchronized (instance){
                if(null == instance){
                    return new SingleDemo1();
                }
            }
        }
        return instance;
    }*/

    /**
     *  保证对象序列化前后，保持一致
     */
    public Object readResole(){
        return instance;
    }
    /**
     * 在内部创建一个静态工厂方法
     *
     */
   /* private static class SingleFactory{
        private static SingleDemo1 instance = new SingleDemo1();
    }

    public SingleDemo1 getInstance(){
       return SingleFactory.instance;
    }*/

    /**
     * 创建与获取分开
     */

    public static SingleDemo1 getInstance(){
        if(null == instance){
            syncInit();
        }
        return instance;
    }

    private static synchronized void syncInit() {
        if(null == instance) {
            instance = new SingleDemo1();
        }
    }
}
