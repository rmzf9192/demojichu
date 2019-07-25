package com.el.jichu.datastructures.search;

/**
 * @author Roman.zhang
 * @Date: 2019/7/17 16:58
 * @Version:V1.0
 * @Description:SeqSearch
 */
public class SeqSearch {
    public static void main(String[] args) {
        // 没有顺序的数组
        int arr[] = { 1, 9, -11, -1, 34, 89 };
        int index = seqSearch(arr, -11);
        if(index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("找到，下标为=" + index);
        }
    }

    private static int seqSearch(int[] arr, int i) {
        for (int j = 0; j < arr.length; j++) {
            if(i == arr[j]){
                return j;
            }
        }
        return -1;
    }
}
