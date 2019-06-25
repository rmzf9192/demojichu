package com.el.jichu.jvm;

import java.io.File;
import java.util.Random;

/**
 * @Auther: roman.zhang
 * @Date: 2019/6/21 9:12
 * @Version:V1.0
 * @Description:JVMDemo
 */
public class JVMDemo {
    private Object obj = new Object();

    public void methodThree(){
       int  args_size=2;
    }

    //局部变量
    public void methodOne(int i) {

        int j = 0;
        int sum = i + j;
        Object abc = obj;
        long start = System.currentTimeMillis();
        methodTwo();
        return;
    }

    private void methodTwo() {

        File file = new File("");
    }

    public static void main(String[] args) {
        String str = "www.atguigu.com" ;
        while(true)
        {
            str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999) ;
        }

      /*  Integer  a=125;
        Integer  b=125;
        Integer  d=300;
        Integer  c=300;
        System.out.println(d==c);
        System.out.println(a==b);

        System.out.println("5"+2);
        JVMDemo demo = new JVMDemo();
        demo.methodOne(1);

        demo.methodThree();*/
    }

}
