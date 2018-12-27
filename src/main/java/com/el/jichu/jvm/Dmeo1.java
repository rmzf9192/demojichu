package com.el.jichu.jvm;

import lombok.val;

import java.util.ArrayList;
import java.util.Random;

public class Dmeo1 {
    public static void main(String[] args) {
        Object o = new Object();
        Dmeo1 dmeo1 = new Dmeo1();

        System.out.println(dmeo1.getClass().getClassLoader().getParent().getParent());
        System.out.println(dmeo1.getClass().getClassLoader().getParent());
        System.out.println(dmeo1.getClass().getClassLoader());
        val list=new ArrayList<String>();
        list.add("jhhh");
        for(val l:list){
            System.out.println("数组中的元素："+l);
        }
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"：hello");
            Thread.currentThread().setPriority(2);
        }).start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"：hello");
            Thread.currentThread().setPriority(10);
        }).start();
/*
        String random="www.baidu.com";
        while(true){
            random+=random+new Random().nextInt(999999999)+new Random().nextInt(999999999);
            System.out.println("数据是："+random);
        }*/
    }


}
//双亲委派机制+沙箱机制