package com.el.jichu.datastructures.binarysorttree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Roman.zhang
 * @Date: 2019/7/29 9:23
 * @Version:V1.0
 * @Description:BinarySortTreeDemo
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {

        String ceshi = String.format("%1$-12s", "ceshi");

        String str = String.format("%1$-30s",ceshi);
        int[] arr = {7, 3, 10, 12, 5, 1, 9,11,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环的添加结点到二叉排序树
        for(int i = 0; i< arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树~");
        binarySortTree.infixOrder(); // 1, 3, 5, 7, 9, 10, 12



        //测试一下删除叶子结点


      /*  binarySortTree.delNode(12);

        binarySortTree.delNode(5);*/
//        binarySortTree.delNode(10);
      /*  binarySortTree.delNode(2);
        binarySortTree.delNode(3);

        binarySortTree.delNode(9);*/
//        binarySortTree.delNode(1);
        binarySortTree.delNode(7);

        System.out.println("root=" + binarySortTree.getRoot());


        System.out.println("删除结点后");
        binarySortTree.infixOrder();

    }
}

/**
 * 创建二叉排序树
 */
class BinarySortTree{
   private Node root;

    public Node getRoot() {
        return root;
    }

    /**
     * 查找父节点
     * @param value
     * @return
     */
    public Node search(int value){
        if(null == root){
            return null;
        } else{
            return root.search(value);
        }
    }

    public Node searchParent(int value){
        if(null == root){
            return null;
        }else{
            return root.searchParent(value);
        }
    }

    /**
     *
     * @param node 出入的节点
     * @return 以node为根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node){
        Node target = node;
        while(target.left !=null){
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    public void delNode(int value) {
        if(null == root){
            return;
        }else{
            Node targetNode = search(value);

            if(null == targetNode){
                return;
            }
            if(null == root.left && null == root.right){
                root = null;
                return;
            }

            //找到targetNode的父节点
            Node parent = searchParent(value);

            //如果删除的是叶子节点
            if(null == targetNode.left && null == targetNode.right){
                //判断target是parent的左子节点还是右子节点
                if(null != parent.left && parent.left.value == value){
                    // 左子节点
                    parent.left = null;
                }else if(null != parent.right && parent.right.value == value){
                    parent.right = null;
                }
            }else if(null != targetNode.left && null !=targetNode.right){
                //删除有两颗子树的节点
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            }else{
                //删除有一个节点
                if(null != targetNode.left){
                    if(null !=parent){
                        if(value == parent.left.value){
                            //targetNode是parent的左子节点
                             parent.left = targetNode.left;
                        }else{
                            //target是parent的右子节点
                            parent.right = targetNode.left;
                        }
                    }else{
                        root = targetNode.left;
                    }
                }else {
                    //如果要删除的有右子节点
                    if(null != parent){
                        if(value == parent.left.value){
                            parent.left = targetNode.right;
                        }else{
                            parent.right = targetNode.right;
                        }
                    }else{
                        root = targetNode.right;
                    }
                }
            }
        }

    }

    /**
     * 添加节点
     * @param node
     */
    public void add(Node node){
        if(null == root){
            root = node;
        }else{
            root.add(node);
        }
    }



    /**
     * 中序遍历
     */
    public void infixOrder(){
        if(null != root){
            root.infixNode();
        }else{
            System.out.println("二叉排序树为空，不能遍历");
        }
    }
}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * 查找对应值的节点
     * @param value 查找的值
     * @return 值所对应的节点
     */
    public Node search(int value){
        if(value == this.value){
            return this;
        }else if (value < this.value){
            if(null == this.left){
                return null;
            }
           return this.left.search(value);
        }else{
            if(null == this.right){
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 返回要删除节点的父节点
     * @param value 查询的节点值
     * @return 节点的父节点
     */
    public Node searchParent(int value){
        if((null != this.left && value == this.left.value) ||
                (null != this.right && value == this.right.value)){
            return this;
        }else{
            if(value < this.value && null !=this.left){
                return this.left.searchParent(value);
            }else if(value >= this.value && null != this.right){
                return this.right.searchParent(value);
            }else{
                return null;
            }
        }
    }

    public Node searchParent1(int value) {
        //如果当前结点就是要删除的结点的父结点，就返回
        if((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果查找的值小于当前结点的值, 并且当前结点的左子结点不为空
            if(value < this.value && this.left != null) {
                return this.left.searchParent(value); //向左子树递归查找
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value); //向右子树递归查找
            } else {
                return null; // 没有找到父结点
            }
        }

    }

    /**
     * 按照二叉排序树的规则，添加节点
     * @param node
     */
    public void add(Node node){
        if(null == node){
            return;
        }
        //判断出入的节点的大小
        if(node.value < this.value){
            if(null == this.left){
                this.left = node;
            }else{
                //递归向左子树添加
                this.left.add(node);
            }
        }else{
            if(null == this.right){
                this.right = node;
            }else{
                //递归向右子树添加
                this.right.add(node);
            }

        }
    }

    /**
     * 中序遍历
     */
    public void infixNode(){
        if(null != this.left){
            this.left.infixNode();
        }
        System.out.println(this);
        if(null != this.right){
            this.right.infixNode();
        }
    }
}
