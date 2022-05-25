package com.el.jichu.datastructures.sort;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * @author Roman.zhang
 * @Date: 2019/7/16 11:07
 * @Version:V1.0
 * @Description:InsertSort
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1, -1, 89,-3};

        int[] arr = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random()*80000);
        }
        LocalTime start = LocalDateTime.now().toLocalTime();
        System.out.println("排序前的时间："+start);
        insertSort(arr);
        LocalTime end = LocalDateTime.now().toLocalTime();
        System.out.println("排序后的时间："+end);

    }

    //插入排序
    public static void insertSort(int[] arr) {

        for (int i = 1; i <arr.length ; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while(insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex -- ;
            }
            arr[insertIndex + 1] = insertVal;
           /* System.out.println("第"+i+"次插入后");
            System.out.println(Arrays.toString(arr));*/
        }

       /* //定义待插入的数
        int insertVal = arr[1];

        int insertIndex = 1-1;

        while(insertIndex >= 0 && insertVal < arr[insertIndex] ){
            arr[insertIndex+1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex+1] = insertVal;

        System.out.println("第一次插入后");
        System.out.println(Arrays.toString(arr));

        insertVal = arr[2];
        insertIndex = 2-1;

        while(insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }

        arr[insertIndex +1] = insertVal;

        System.out.println("第二次插入后");
        System.out.println(Arrays.toString(arr));

        insertVal = arr[3];
        insertIndex = 3-1;

        while(insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }

        arr[insertIndex+1] = insertVal;

        System.out.println("第三次插入后");
        System.out.println(Arrays.toString(arr));

        insertVal = arr[4];
        insertIndex = 4-1;

        while(insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex+1] = arr[insertIndex];
            insertIndex -- ;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第四次插入后");
        System.out.println(Arrays.toString(arr));

        insertVal = arr[5];
        insertIndex = 5-1;
        while(insertIndex > 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex+1] = insertVal;

        System.out.println("第四次插入后");
        System.out.println(Arrays.toString(arr));*/
    }
}
