package com.el.jichu.datastructures.sort;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * @author Roman.zhang
 * @Date: 2019/7/16 15:25
 * @Version:V1.0
 * @Description:ShellSort
 */
public class ShellSort {

    public static void main(String[] args) {
//        int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };

        int[] arr = new int[8000000];

        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random()*8000000);
        }
        LocalTime start = LocalDateTime.now().toLocalTime();
        System.out.println("排序前的时间："+start);
        shellSort2(arr);
        LocalTime end = LocalDateTime.now().toLocalTime();
        System.out.println("排序后的时间："+end);
    }

    /**
     * 希尔排序-交换法
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        for (int gap = arr.length/2; gap > 0; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >=0 ; j -= gap) {
                    if(arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//           System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
        }
     /*   for (int i = 5; i < arr.length; i++) {
            for (int j = i-5; j >= 0 ; j-= 5) {
                if(arr[j] > arr[j+5]){
                    temp = arr[j];
                    arr[j] = arr[j+5];
                    arr[j+5] = temp;
                }
            }
        }
        System.out.println("希尔排序1轮后=" + Arrays.toString(arr));

        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0 ; j -= 2) {
                if(arr[j] > arr[j+2]){
                    temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }
        System.out.println("希尔排序2轮后=" + Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {
            for (int j = i -1; j >= 0 ; j -= 1) {
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("希尔排序3轮后=" + Arrays.toString(arr));*/
    }

    //对交换式的希尔排序进行优化->移位法
    public static void shellSort2(int[] arr) {
        int count = 0;
        for (int gap = arr.length/2; gap > 0; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j - gap]){
                    while(j - gap >= 0 && temp < arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }
            }
//            System.out.println("希尔排序"+(++count)+"轮后=" + Arrays.toString(arr));
        }
    }
}
