package com.el.jichu.datastructures.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman.zhang
 * @Date: 2019/7/17 17:03
 * @Version:V1.0
 * @Description:BinarySearch
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};
//        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 , 11, 12, 13,14,15,16,17,18,19,20 };


        //
     /*   int resIndex = binarySearch(arr, 0, arr.length - 1, 1234);
        System.out.println("resIndex=" + resIndex);*/

        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println("resIndexList=" + resIndexList);
    }

    private static int binarySearch(int[] arr, int left, int rigth, int value) {
        if (left > rigth) {
            return -1;
        }
        // 获取中间值
        int mid = (left + rigth) / 2;
        int midVal = arr[mid];

        if (value < midVal) {
            //左递归
            return binarySearch(arr, left, mid - 1, value);
        } else if (value > midVal) {
            //右递归
            return binarySearch(arr, mid + 1, rigth, value);
        } else {
            return mid;
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        System.out.println("hello~");
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { // 向 右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            return binarySearch2(arr, left, mid - 1, findVal);

        }else{
            List<Integer> list = new ArrayList<>();

            int temp = mid -1;
            while (true){
                if(temp < 0 || arr[temp] != findVal){
                    break;
                }
                list.add(temp);
                temp-=1;
            }
            list.add(mid);

            temp = mid + 1;

            while(true) {
                if(temp > right || arr[temp]!=findVal){
                    break;
                }
                list.add(temp);
                temp+=1;
            }
            return list;
        }
    }
}
