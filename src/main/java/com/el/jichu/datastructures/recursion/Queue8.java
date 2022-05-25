package com.el.jichu.datastructures.recursion;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author Roman.zhang
 * @Date: 2019/7/15 16:31
 * @Version:V1.0
 * @Description:Queue8
 */
public class Queue8 {
    int max = 8;
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount =0;
    public static void main(String[] args) {

        int total = 0;
        int end =1000;
        long start = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        int sum = (end+1)*end/2;
        System.out.println(sum);
        for (int i = 0; i <= end; i++) {
            total += (1+end)*end/2;
            total +=i;
        }
        System.out.println(total);
        long endt = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(endt - start);
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d解法", count);
        System.out.printf("一共判断冲突的次数%d次", judgeCount); // 1.5w
    }

    /**
     * 放置第n个皇后：特别注意
     *    check每次递归时，进入到check中都有for(int i=0;i < max;i++),因此会有回溯
     * @param n
     */
    private void check(int n) {
        // 8个皇后都已经放好
        if (n == max){
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            //先把皇后放第一个位置
            array[n] = i;
            //判断是否冲突
            if(judge(n)){
                // 不冲突 ，接着放n+1个皇后，即开始递归
                check(n+1);
            }
            // 如果冲突，继续执行array[n],即将皇后放在本行的位置后移一位
        }
    }

    /**
     * 查看下，当我们摆放第n个皇后的位置时，是否与前面已摆放的皇后的位置相冲突
     * @param n
     * @return
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            // 说明
            //1. array[i] == array[n]  表示判断 第n个皇后是否和前面的n-1个皇后在同一列
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线
            // n = 1  放置第 2列 1 n = 1 array[1] = 1
            // Math.abs(1-0) == 1  Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
            //3. 判断是否在同一行, 没有必要，n 每次都在递增
            if(array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }

        return true;
    }

    /**
     * 输出皇后所摆放的位置
     */
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
