package com.el.jichu.thread.cas;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/22 14:53
 * @Version:V1.0
 * @Description:TestCompareAndSwap
 */
public class TestCompareAndSwap {

    public static void main(String[] args) {
        CompareAndSwap swap = new CompareAndSwap();
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int swapValue = swap.getValue();
                    boolean b = swap.compareTowValue(swapValue, (int) (Math.random() * 101));
                    System.out.println(Thread.currentThread().getName() + ":" + b);
                }
            }).start();
        }

    }

}

class CompareAndSwap {
    //设置内存值
    private int value;

    public synchronized int getValue() {
        return value;
    }

    //比较期望值与新值
    public synchronized boolean compareTowValue(int expectedValue, int newValue) {
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }

    private synchronized int compareAndSwap(int expectedValue, int newValue) {
        //获取内存值
        int oldValue = value;
        if (oldValue == expectedValue) {
            this.value = newValue;
        }
        return oldValue;
    }
}
