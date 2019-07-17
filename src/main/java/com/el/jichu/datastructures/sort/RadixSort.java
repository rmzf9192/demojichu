package com.el.jichu.datastructures.sort;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * @author Roman.zhang
 * @Date: 2019/7/17 15:39
 * @Version:V1.0
 * @Description:RadixSort
 */
public class RadixSort {
    public static void main(String[] args) {
//        int arr[] = { 53, 3, 542, 748, 14, 214};
        int[] arr = new int[8000000];

        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random()*8000);
        }
        LocalTime start = LocalDateTime.now().toLocalTime();
        System.out.println("排序前的时间："+start);
        radixSort(arr);
        LocalTime end = LocalDateTime.now().toLocalTime();
        System.out.println("排序后的时间："+end);
    }

    /**
     * 基数排序方法
     * @param arr
     */
    public static void radixSort(int[] arr) {

        //根据前面的推到过程,首先获取最大值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }

        int maxLength = (max+"").length();


        //定义一个二维数组，表示10个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含10个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        //3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如：bucketElementCounts[0] , 记录的就是  bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0,n=1; i < maxLength; i++,n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                //放到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if(bucketElementCounts[k] != 0){
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //第一轮处理后，需要将每个元素bucketElementCounts[k] 至为0
                bucketElementCounts[k] = 0;
            }
            //System.out.println("第"+(i+1)+"轮，对个位的排序处理 arr =" + Arrays.toString(arr));
        }
      /*  //第1轮(针对每个元素的个位进行排序处理)


        //遍历每个桶，并把桶中的数据取出，给原数组
        int index = 0;
        for (int i = 0; i < bucketElementCounts.length; i++) {
            if(bucketElementCounts[i] != 0){
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    //取出元素放到arr
                    arr[index++] = bucket[i][j];
                }
            }
            //第一轮处理后，需要将每个元素bucketElementCounts[k] 至为0
            bucketElementCounts[i] = 0;
        }
        System.out.println("第1轮，对个位的排序处理 arr =" + Arrays.toString(arr));

        //第二轮针对十位数排序
        for (int i = 0; i < arr.length; i++) {
            int digitOfElement = arr[i] / 10 % 10;
            //放到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        //遍历每个桶，并将桶中的数据还原给原数组
        index = 0;
        for (int i = 0; i < bucketElementCounts.length; i++) {
            if(bucketElementCounts[i]!=0){
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            bucketElementCounts[i] = 0;
        }
        System.out.println("第2轮，对个位的排序处理 arr =" + Arrays.toString(arr));

        //第三次遍历百位
        for (int i = 0; i < arr.length; i++) {
            int digitOfElement = arr[i] / 100 % 10;
            //放到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        //遍历每个桶，并将桶中的数据还原给原数组
        index = 0;
        for (int i = 0; i < bucketElementCounts.length; i++) {
            if(bucketElementCounts[i]!=0){
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            bucketElementCounts[i] = 0;
        }
        System.out.println("第3轮，对个位的排序处理 arr =" + Arrays.toString(arr));

*/
    }
}
