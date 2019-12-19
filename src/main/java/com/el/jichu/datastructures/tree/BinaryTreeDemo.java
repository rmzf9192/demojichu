package com.el.jichu.datastructures.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Roman.zhang
 * @Date: 2019/7/18 11:17
 * @Version:V1.0
 * @Description:BinaryTreeDemo
 */

public class BinaryTreeDemo {

    public static void main(String[] args) {

        String str = "uuio";

        boolean u = str.contains("u0io");
        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();

        //创建节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        //手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        //前序遍历
        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.infixOrder();
        System.out.println("后序遍历");
        binaryTree.postOrder();

     /*   System.out.println("前序遍历查找");
        //前序遍历的次数 ：4
        HeroNode heroNode = binaryTree.preOrderSearch(5);
        if(null != heroNode){
            System.out.printf("找到了信息 no= %d   name= %s",heroNode.getNo(),heroNode.getName());
        }else{
            System.out.println("没有找到");
        }
        //中序遍历查找
        //中序遍历3次
		System.out.println("中序遍历方式~~~");
		HeroNode resNode = binaryTree.infixOrderSearch(5);
		if (resNode != null) {
			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
		} else {
			System.out.printf("没有找到 no = %d 的英雄", 5);
		}
*/
        //后序遍历查找
        //后序遍历查找的次数  2次
	/*	System.out.println("后序遍历方式~~~");
		HeroNode resNode = binaryTree.postOrderSearch(5);
		if (resNode != null) {
			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
		} else {
			System.out.printf("没有找到 no = %d 的英雄", 5);
		}*/

   /*     System.out.println("删除前遍历");
		binaryTree.preOrder();
        System.out.println("删除后遍历");
        binaryTree.delNo(3);
        binaryTree.preOrder();*/
    }
}

/**
 * 定义二叉树
 */
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 删除节点
     * @param no
     */
    public void delNo(int no){
        if(null!=root){
            //只有一个节点，则删除
            if(no == root.getNo()){
                root = null;
            }else{
                root.delNode(no);
            }
        }else{
            System.out.println("树为空树");
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        if(null != this.root ){
            root.preOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder(){
        if(null != this.root ){
            root.infixOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        if(null != this.root ){
            root.postOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //前序遍历
    public HeroNode preOrderSearch(int no) {
        if(null != this.root) {
           return root.preOrderSearch(no);
        }else{
            System.out.println("二叉树为空，无法遍历");
            return null;
        }
    }

    //中序遍历
    public HeroNode infixOrderSearch(int no) {
        if(root != null) {
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    //后序遍历
    public HeroNode postOrderSearch(int no) {
        if(root != null) {
            return this.root.postOrderSearch(no);
        }else {
            return null;
        }
    }
}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 递归删除
     * 1.如果删除的节点是叶子节点，则递归删除叶子节点
     * 2.如果删除的节点是非叶子节点，则递归删除该子树
     * @param no
     */
    public void delNode(int no){
        /*
		 * 	1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
			2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
			3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
			4. 如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
			5.  如果第4步也没有删除结点，则应当向右子树进行递归删除.
		 */

        //如果当前节点的左子节点不为空，且左节点就是要删除的节点，就将this.left = null ,并且返回（结束递归）
        if(this.left != null && this.left.no == no ){
            this.left = null;
            return;
        }
        //如果当前节点的右子节点不为空，且右节点就是要删除的节点，就将this.left = null,并且返回（结束递归）
        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }

        //如果左子树不为空
        if(this.left != null){
            this.left.delNode(no);
        }
        //如果右子树不为空
        if(this.right != null){
            this.right.delNode(no);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        //先输出父节点
        System.out.println(this);

        if(this.left!= null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder(){
        //递归左子树遍历
        if(this.left!= null){
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);

        //递归右子树
        if(this.right != null){
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        //遍历左子树
        if(this.left != null){
            this.left.postOrder();
        }
        //遍历右子树
        if(this.right != null){
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }

    /**
     * 前序查找
     * @param no 查找节点
     * @return 如果找到就返回HeroNode,找不到就返回null
     */
    public HeroNode preOrderSearch(int no){
        System.out.println("进入前序查找");

        //判断当前节点是不是所查找的
        if(this.no == no){
            return this;
        }
        //判断当前节点的左子节点是否为null,不为null,则向左子节点遍历
        // 左递归查找，找到节点就返回
        HeroNode temp =null;
        if(this.left != null){
            temp = this.left.preOrderSearch(no);
        }
        if(null != temp){
            return temp;
        }
        //如果左递归没有找到对应节点，则右递归
        //当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找 右递归查找
        if(this.right != null){
            temp = this.right.preOrderSearch(no);
        }
        return temp;
    }

    /**
     * 中序查找
     * @param no
     * @return
     */
    public HeroNode infixOrderSearch(int no){
        // 判读当前节点是否为空，如果不为空，则递归中序遍历
        HeroNode temp = null;
        if(this.left != null){
            temp = this.left.infixOrderSearch(no);
        }
        if(null != temp) {
            return temp;
        }
        System.out.println("进入中序遍历");

        if(no == this.no){
            return this;
        }
        if(null !=this.right){
            temp = this.right.infixOrderSearch(no);
        }
        return temp;
    }

    /**
     * 后序查找
     * @param no
     * @return
     */
    public HeroNode postOrderSearch(int no){
        //首先判断当前节点的左子节点是否为null,不为null,则左递归遍历
        HeroNode temp = null;
        if(null != this.left){
            temp = this.left.postOrderSearch(no);
        }
        if(null != temp){
            return temp;
        }
        //如果左子树没有找到，且右子树不为null，则右递归
        if(null != this.right){
            temp = this.right.postOrderSearch(no);
        }
        if(null != temp){
            return temp;
        }
        System.out.println("进入后序遍历");
        if(no == this.no){
            return this;
        }
        return temp;
    }

}
