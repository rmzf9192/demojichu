package com.el.jichu.datastructures.sort;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Arrays;

/**
 * @author Roman.zhang
 * @Date: 2019/7/15 17:52
 * @Version:V1.0
 * @Description:BubbleSort
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int arr[] = {3, 9, -1, 10, 20};
        int[] arr = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random()*8000);
        }
        LocalTime start = LocalDateTime.now().toLocalTime();
        System.out.println("排序前的时间："+start);
        bubbleSort(arr);
        LocalTime end = LocalDateTime.now().toLocalTime();
        System.out.println("排序后的时间："+end);
		/*System.out.println("排序前");
		System.out.println(Arrays.toString(arr));

		int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第一趟排序后");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1-1; i++) {
            if(arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第一趟排序后");
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1-2; i++) {
            if(arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第二趟排序后");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1-3; i++) {
            if(arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第三趟排序后");
        System.out.println(Arrays.toString(arr));
*/
    }

    public static void bubbleSort(int[] arr) {
        int temp = 0;
        //冒泡排序优化
        boolean flag = true;
        for (int j = 0; j < arr.length-1; j++) {
            for (int i = 0; i < arr.length - 1-j; i++) {
                if(arr[i] > arr[i+1]){
                    flag = false;
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
          /*  System.out.println("第"+(j+1)+"趟排序后");
            System.out.println(Arrays.toString(arr));*/
            if(flag){
                break;
            }else{
                flag = true;
            }
        }
    }
}
