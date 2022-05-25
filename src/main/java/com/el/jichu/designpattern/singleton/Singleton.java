package com.el.jichu.designpattern.singleton;

import java.util.Vector;

/**
 * 单例模式-
 */
public class Singleton {

    //持有私有化静态变量，防止被引用，此处赋值为null,目的是延迟加载
    private static Singleton instance = null;

    private Vector properties = null;

    public Vector getProperties() {
        return properties;
    }

    //私有化构造方法，防止被引用
    private Singleton() {

    }

    /* //静态工程方法，创建实例--缺陷
     public static Singleton getInstance(){
        if(instance==null){
            synchronized (instance){
                return new Singleton();
            }
        }
        return instance;
     }*/
    //使用内部类维护一个实例
    private static class SingletonFactory {
        private static Singleton singleton = new Singleton();
    }

    //获取实例
    public static Singleton getInstance() {

        return SingletonFactory.singleton;
    }

    //如果该对象被序列化，可以保证该对象在序列化前后保持一致。
    public Object readResolve() {
        return instance;
    }


    private static synchronized void synint() {
        if (instance == null) {
            instance = new Singleton();
        }
    }

    public static Singleton getInstance1() {
        if (instance == null) {
            synint();
        }
        return instance;
    }

    public void getPropertise() {
        Singleton singleton = new Singleton();
        singleton.getPropertise();
    }

}
