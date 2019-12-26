package com.el.jichu.thread.thread;

/**
 * @author roman zhangfei
 * @Date 2019/10/14 16:09
 * @Version V1.0
 */
public class Thread8LockMointor {

    public static void main(String[] args) {
        Number number = new Number();
        Number number1 = new Number();

        new Thread(()->{
            number.getOne();
        }).start();

        new Thread(()->{
            number1.getTwo();
        }).start();

      /*  new Thread(()->{
            number.getThree();
        }).start();*/
    }
}

class Number{
    public static synchronized void getOne(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }
    public static synchronized void getTwo(){
        System.out.println("two");
    }

    public void getThree(){
        System.out.println("Three");
    }
}
