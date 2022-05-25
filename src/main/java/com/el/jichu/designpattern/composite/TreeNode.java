package com.el.jichu.designpattern.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/28 9:28
 * @Version:V1.0
 * @Description:TreeNode
 */
public class TreeNode {
    private String name;
    private TreeNode parent;

    private Vector<TreeNode> children = new Vector<>();

    public TreeNode(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //添加孩子节点
    public void add(TreeNode node) {
        children.add(node);
    }

    //删除孩子节点
    public void remove(TreeNode node) {

        children.remove(node);
    }

    //取得孩子节点
    public Enumeration<TreeNode> getChildren() {
        return children.elements();
    }

}
