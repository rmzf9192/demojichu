package com.el.jichu.thread.vol;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/22 15:24
 * @Version:V1.0
 * @Description:TestVolatile
 *
 *  volatile关键字：相当于多个线程访问共享数据时，可以保证内存中的数据的可见性
 *                  相当于synchronized是一种较为轻量级的同步锁策略
 *
 *   注意：
 *    1.volatile:不具备“互斥性”
 *    2.volatile:不能保证原子性
 */
public class TestVolatile {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();

        Thread thread = new Thread(threadDemo);
        thread.start();

        System.out.println("子线程结束");

        //thread.yield();//线程让步
        while(true){
            if(threadDemo.isFlag()){
                System.out.println("-----------------------");
                break;
            }
        }
    }
}

class ThreadDemo implements Runnable{

    private volatile boolean flag=false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag=true;

        System.out.println("flag="+flag);
    }

    public boolean isFlag(){
        return flag;
    }

    public void setFlag(boolean flag){
        this.flag=flag;
    }

}
