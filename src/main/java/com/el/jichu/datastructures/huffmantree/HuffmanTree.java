package com.el.jichu.datastructures.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Roman.zhang
 * @Date: 2019/7/25 11:32
 * @Version:V1.0
 * @Description:HuffmanTree
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
        Node root = createHuffmanTree(arr);

        //测试一把
        preOrder(root); //
    }

    /**
     * 前序遍历
     * @param root
     */
    public static void preOrder(Node root){
        if(null != root){
            root.preOrder();
        }else{
            System.out.println("空树，不能遍历");
        }
    }

    /**
     * 创建赫夫曼树的方法
     * @param arr 需要创建成哈夫曼树的数组
     * @return 创建好后的赫夫曼树的root节点
     */
    public static Node createHuffmanTree(int[] arr){

        /**
         * 将arr中的元素放到List集合。
         */
        List<Node> nodes = new ArrayList<>();
        for (int a:arr
             ) {
            nodes.add(new Node(a));
        }

        while(nodes.size() > 1){
            //排序，从小到大
            Collections.sort(nodes);
            System.out.println("nodes:"+nodes);
            //取出根节点最小的两颗二叉树
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            //创建一个新的二叉树
            Node parents = new Node(left.value + right.value);

            parents.left = left;
            parents.right = right;

            //list集合中删除对应的元素
            nodes.remove(left);
            nodes.remove(right);

            //将父节点加入到list
            nodes.add(parents);
        }
        //返回哈夫曼树
        return nodes.get(0);
    }
}

/**
 * 创建节点类，为了让Node对象持续排序，实现Comparable接口
 */
class Node implements Comparable<Node>{
    //节权值
    int value;
    char c; //字符
    //左子节点
    Node left;
    //右子节点
    Node right;

    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println(this);
        if(null != this.left){
            this.left.preOrder();
        }
        if(null != this.right){
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", c=" + c +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
