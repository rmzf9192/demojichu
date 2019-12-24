package com.el.jichu.datastructures.sort;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * @author Roman.zhang
 * @Date: 2019/7/25 10:36
 * @Version:V1.0
 * @Description:HeapSort
 */
public class HeapSort {
    public static void main(String[] args) {
//要求将数组进行升序排序
//        int arr[] = {4, 6, 8, 5, 9};
        // 创建要给80000个的随机的数组
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }
        System.out.println("排序前");
        LocalTime start = LocalDateTime.now().toLocalTime();
        System.out.println("排序前的时间："+start);

        heapSort(arr);

        LocalTime end = LocalDateTime.now().toLocalTime();
        System.out.println("排序后的时间："+end);
//        System.out.println("排序后=" + Arrays.toString(arr));
    }

    //编写一个堆排序的方法
    public static void heapSort(int arr[]) {
        int temp = 0;
        System.out.println("堆排序开始");

        //分布完成
       /* adjustHeap(arr,1,arr.length);
        System.out.println("第一次排序"+ Arrays.toString(arr));//4, 9, 8, 5, 6
        adjustHeap(arr,0,arr.length);
        System.out.println("第二次排序"+Arrays.toString(arr));//9, 6, 8, 5, 4*/

       // 将无序序列构成一个堆，根据升序选择大顶堆，降序选择小顶堆
        int count = 0;
        for (int i = arr.length/2; i >= 0 ; i--) {
            adjustHeap(arr,i,arr.length);
//            System.out.println("第"+(++count)+"调整:"+Arrays.toString(arr));
        }

        /**
         * 将堆顶元素与末尾元素交换，将最大元素跳整到末尾
         *  重新调整堆结构，使其满足堆定义，然后继续堆顶元素与末尾元素交换，将最大元素跳整到末尾 反复执行调整+交换步骤，直到整个序列有序
         */

        for (int i = arr.length -1; i >= 0; i--) {
            //交换
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,i);
        }
//        System.out.println("数组=" + Arrays.toString(arr));
    }

    /**
     * 将一个数组（二叉树），调成一个大堆
     * 功能： 完成 将 以 i 对应的非叶子结点的树调整成大顶堆
     * 举例  int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到 {4, 9, 8, 5, 6}
     * 如果我们再次调用  adjustHeap 传入的是 i = 0 => 得到 {4, 9, 8, 5, 6} => {9,6,8,5, 4}
     * @param arr  待调整的数组
     * @param i  表示非叶子节点在数组中的索引
     * @param length 表示对多少元素在调整，在逐渐减少
     */
    public static void adjustHeap(int arr[] ,int i,int length){
        int temp = arr[i];

        //开始调整
        //1. k = i * 2 + 1 k 是 i结点的左子结点
        for (int k = i * 2 + 1; k < length ; k = i * 2 + 1) {
            //说明左子节点小于右子节点
            if(k+1 < length && arr[k] < arr[k+1]){
                //k指向右子节点
                k++;
            }
           //如果子节点大于父节点
            if(arr[k] > temp){
                //把较大的值，放到前面
                arr[i] = arr[k];
                //将i指向k,继续循环使用
                i = k;
            }else{
                break;
            }
        }
        //当for 循环结束后，我们已经将以i 为父结点的树的最大值，放在了 最顶(局部)
        arr[i] = temp;//将temp值放到调整后的位置
    }
}

