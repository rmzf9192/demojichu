package com.el.jichu.sort;

public class ArraySort implements Runnable {
    private String num;

    public ArraySort(int num) {
        this.num = num+"";
    }

    public ArraySort() {
    }

    public static void main(String[] args){
         //把这个数字升序输出
        int[]  nums={11,3,998,5455,5455,152,990};

        for(int i=0;i<nums.length;i++){
            ArraySort arraySort = new ArraySort(nums[i]);
            new Thread(arraySort).start();
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Integer.parseInt(num));
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
