package com.el.jichu.datastructures.tree;

/**
 * @author Roman.zhang
 * @Date: 2019/7/18 14:48
 * @Version:V1.0
 * @Description:ArrBinaryTreeDemo
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

        //创建一个 ArrBinaryTree
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(); // 1,2,4,5,3,6,7
    }


}

class ArrBinaryTree{
    //存储数据节点的数组
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        preOrder(0);
    }
    /**
     * 前序方式遍历数组
     * @param index
     */
    public void preOrder(int index) {
        if(null == arr || arr.length == 0 ){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }
        System.out.println("输出当前元素:"+arr[index]);

        //向左递归遍历
        if((index*2+1) < arr.length){
            preOrder(index*2+1);
        }
        //向右递归遍历
        if((index*2)+2 < arr.length){
            preOrder(index*2+2);
        }
    }
}
