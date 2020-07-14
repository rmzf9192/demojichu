package com.el.jichu.designpattern.proxy.aop;


import java.time.LocalDateTime;


/**
 * @Auther: roman.zhang
 * @Date: 2019/4/12 9:15
 * @Version:V1.0
 * @Description:Logger
 */
public class Logger {
    public static  void start(){
        System.out.println(LocalDateTime.now() +" Logger start is runing");
    }
    public static void end(){
        System.out.println(LocalDateTime.now()+" Logger start is runing");
    }

}
