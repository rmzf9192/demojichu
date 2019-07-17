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
           /* total += (1+end)*end/2;*/
            total +=i;
        }
        System.out.println(total);
        long endt = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(endt - start);
     /*   Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d解法", count);
        System.out.printf("一共判断冲突的次数%d次", judgeCount); // 1.5w*/
    }

    private void check(int n) {
        if (n == max){
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            //先把皇后放第一个位置
            array[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }
    }

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

    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
