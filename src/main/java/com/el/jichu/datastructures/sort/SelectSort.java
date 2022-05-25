package com.el.jichu.datastructures.sort;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Roman.zhang
 * @Date: 2019/7/16 10:37
 * @Version:V1.0
 * @Description:SelectSort
 */
public class SelectSort {
    public static void main(String[] args) {
//        int [] arr = {101, 34, 119, 1, -1,-1, 90, 123};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random()*8000);
        }
        LocalTime start = LocalDateTime.now().toLocalTime();
        System.out.println("排序前的时间："+start);
        selectSort(arr);
        LocalTime end = LocalDateTime.now().toLocalTime();
        System.out.println("排序后的时间："+end);

    }

    public static void selectSort(int[] arr) {
        Long count = 1L;
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = 1+i; j < arr.length; j++) {
                count++;
                // > :从小到大  <:从大到小
                if(min < arr[j]){
                    minIndex = j;
                    min = arr[j];
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
         /*   System.out.println("第"+(i+1)+"轮后~~");
            System.out.println(Arrays.toString(arr));// [-1, 34, 119, 1, 101, 90, 123]*/
        }

      /*  int minIndex = 0;
        int min = arr[minIndex];

        for (int  i=1+0; i < arr.length; i++) {
            if(min > arr[i]){
                minIndex = i;
                min = arr[i];
            }
        }
        if(minIndex !=0){
            arr[minIndex] = arr[0];
            arr[0] = min;
        }

        System.out.println("第1轮后~~");
        System.out.println(Arrays.toString(arr));// [-1, 34, 119, 1, 101, 90, 123]

         minIndex = 1;
         min = arr[minIndex];
        for (int  i=1+1; i < arr.length; i++) {
            if(min > arr[i]){
                minIndex = i;
                min = arr[i];
            }
        }
        if(minIndex !=1){
            arr[minIndex] = arr[1];
            arr[1] = min;
        }

        System.out.println("第2轮后~~");
        System.out.println(Arrays.toString(arr));// [-1, 1, 119, 34, 101, 90, 123]

        minIndex = 2;
        min = arr[2];

        for (int i = 1 + 2; i < arr.length; i++) {
            if(min > arr[i]){
                min = arr[i];
                minIndex = i;
            }
        }

        if(minIndex != 2){
            arr[minIndex] = arr[2];
            arr[2] = min;
        }
        System.out.println("第3轮后~~");
        System.out.println(Arrays.toString(arr));// [-1, 1, 119, 34, 101, 90, 123]*/

        System.out.println(count);
    }
}
