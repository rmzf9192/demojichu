package com.el.jichu.algorithm.binarySearchnorecursion;

/**
 * @author Roman.zhang
 * @Date: 2019/7/31 9:22
 * @Version:V1.0
 * @Description:BinarySearchRecur
 */
public class BinarySearchRecur {
    public static void main(String[] args) {
        //测试
        int[] arr = {1,3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 100);
        System.out.println("index=" + index);//
    }

    /**
     * 二分法查找
     * @param arr 查找的数组
     * @param target 查找的数
     * @return 返回查到的数的下标
     */
    public static int binarySearch(int [] arr,int target){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
           int  mid = (left+right) / 2;

           if(arr[mid] == target){
               return mid;
           }else if(arr[mid] > target){
               right = mid -1;
           }else{
               left = mid + 1;
           }
        }
        return -1;
    }
}
