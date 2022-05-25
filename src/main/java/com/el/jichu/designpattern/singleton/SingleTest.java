package com.el.jichu.designpattern.singleton;

import java.util.Vector;

/**
 * @author Roman.zhang
 * @Date: 2019/7/4 14:46
 * @Version:V1.0
 * @Description:SingleTest
 */
public class SingleTest {
    private static SingleTest instance = null;

    private Vector properties =  null;

    public SingleTest(){

    }

    public Vector getProperties(){
        return properties;
    }

    public static synchronized void  syncInit(){
        if(null == instance){
            instance = new SingleTest();
        }
    }

    public static SingleTest getInstance(){
        if(null == instance){
            syncInit();
        }
        return instance;
    }

    public void updateProperties(){
        SingleTest singleTest = new SingleTest();
        properties = singleTest.getProperties();
    }
}
