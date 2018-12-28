package com.el.jichu.designpattern.composite;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/28 10:10
 * @Version:V1.0
 * @Description:Tree:组合模式测试
 * 使用场景：将多个对象组合在一起进行操作，常用于表示树形结构中，例如二叉树，数等。
 */
public class Tree {
    private TreeNode treeNode=null;

    public Tree(String name) {
        this.treeNode = new TreeNode(name);
    }

    public static void main(String[] args) {
        Tree tree = new Tree("A");

        TreeNode treeNode1 = new TreeNode("B");
        TreeNode treeNode2 = new TreeNode("C");
        treeNode1.add(treeNode2);

        tree.treeNode.add(treeNode1);

        System.out.println("build the tree finished");
    }

}
