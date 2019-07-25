package com.el.jichu.datastructures.tree.threadedBinaryTree;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Roman.zhang
 * @Date: 2019/7/23 19:53
 * @Version:V1.0
 * @Description:ThreadedBinaryTreeDemo 线索化二叉树
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //测试中序线索化二叉树
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree binaryTree = new ThreadedBinaryTree();
        binaryTree.setRoot(root);
        binaryTree.threadedNodes();

        //测试: 以10号节点测试
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10号结点的前驱结点是 ="  + leftNode); //3
        System.out.println("10号结点的后继结点是="  + rightNode); //1

        //当线索化二叉树后，能在使用原来的遍历方法
        //threadedBinaryTree.infixOrder();
        System.out.println("使用线索化的方式遍历 线索化二叉树");
        binaryTree.threadedList(); // 8, 3, 10, 1, 14, 6
    }
}

/**
 * 实现线索化二叉树查找
 */
class ThreadedBinaryTree{
    private HeroNode root;
    /**
     * 为实现线索化查找，需要创建指定当前节点的前驱节点的指针
     * 在递归线索化时，pre总是保留前一个节点
     */
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedNodes(){
        this.threadedNodes(root);
    }
    public void threadedList(){
        // 定义一个变量存储当前变量的节点,从root开始
        HeroNode node = root;

        while(null != root){
            /*
            循环遍历查找，当leftValue == 1时，第一个节点就是8
            后面随着循环遍历而遍历，因为当leftValue == 1时，说明是按照线索化查找
            处理有效节点
             */
            while(0 == node.getLeftValue()){
                node = node.getLeft();
            }
            //输出有效节点
            System.out.println(node);
            // 如果当前节点的右指针，指向的是后继节点，就一直输出
            while(1 == node.getRightValue()){
                // 获取当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            // 替换遍历的节点
            node = node.getRight();
        }
    }

    /**
     * 二叉树的中序线索化查找
     * @param node 当前线索化的的节点
     */
    public void threadedNodes(HeroNode node){
        if (null == node){
            return;
        }
        //线索化左子树
        threadedNodes(node.getLeft());
        //线索化当前节点
        //以8节点为例，8.left = null ,则8.leftValue == 1
        if(null == node.getLeft()){
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针的类型，leftValue == 1
            node.setLeftValue(1);
        }
        System.out.println(node);
        //处理后继节点
        if(null != pre && null == pre.getRight()){
            // 让前驱节点的右指针指向当前节点
            pre.setRight(node);
            // 修改前驱节点的右指针类型
            pre.setRightValue(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

        // 线索化右子树
        threadedNodes(node.getRight());


    }

    /**
     * 删除节点
     * @param no
     */
    public void delNode(int no){
        if(null != root){
            if(no == root.getNo()){
                root = null;
            }else{
               root.delNode(no);
            }
        }else{
            System.out.println("空树，不能删除");
        }
    }

    //前序遍历
    public void preOrder(){
        if(null != this.root){
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空，不能遍历");
        }
    }
    //中序遍历
    public void infixOrder(){
        if(null != this.root){
            this.root.infixOrder();
        }else{
            System.out.println("二叉树为空，不能遍历");
        }
    }

    //后序遍历
    public void postOrder(){
        if(null != this.root){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空，不能遍历");
        }
    }

    /**
     * 前序遍历查找
     * @param no
     */
    public HeroNode preOrderSearch(int no){
        if(null != root){
           return this.root.preOrderSearch(no);
        }else{
            return null;
        }
    }

    /**
     * 中序遍历查找
     * @param no
     */
    public HeroNode infixOrderSearch(int no){
        if(null != root){
            return this.root.infixOrderSearch(no);
        }else{
            return null;
        }
    }

    /**
     * 后序遍历查找
     * @param no
     */
    public HeroNode postOrderSearch(int no){
        if(null != root){
            return this.root.postOrderSearch(no);
        }else{
            return null;
        }
    }

}


/**
 * 先创建HeroNode节点
 */
@Slf4j
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    //默认为null
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    /**
     * 说明
     *    1.如果leftValue == 0 ,表明指向左子树，如果是1则指向前驱节点
     *    2.如果rightValue == 0 ,表明指向右子树，如果是1则指向后驱节点
     */
    private int leftValue;
    private int rightValue;

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

    public int getLeftValue() {
        return leftValue;
    }

    public void setLeftValue(int leftValue) {
        this.leftValue = leftValue;
    }

    public int getRightValue() {
        return rightValue;
    }

    public void setRightValue(int rightValue) {
        this.rightValue = rightValue;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * //递归删除结点
     * 	1.如果删除的节点是叶子节点，则删除该节点
     * 	2.如果删除的节点是非叶子节点，则删除该子树
     * @param no
     */
    public void delNode(int no){
        //思路
		/*
		 * 	1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
			2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
			3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
			4. 如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
			5.  如果第4步也没有删除结点，则应当向右子树进行递归删除.

		 */

		//如果当前节点的左子节点不为空，且该节点就是删除的节点，就将this.left = null ,并且返回（递归删除）
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }

        //如果当前节点的右子节点不为空，且该节点就删删除的节点，就将this.left = null 并且返回（递归删除）
        if(this.right != null && no == this.right.no){
            this.right = null;
            return;
        }

        //向左子树递归
        if(null != this.left){
            this.left.delNode(no);
        }
        //向右子树递归
        if(null != this.right){
            this.right.delNode(no);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        log.info("前序遍历开始");
        System.out.println(this);

        //向左子树遍历
        if(null != this.left){
            this.left.preOrder();
        }
        //向右子树遍历
        if(null != this.right){
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder(){
        log.info("中序遍历开始");
        //先遍历左子树
        if(null != this.left){
            this.left.infixOrder();
        }
        System.out.println(this);
        //遍历右子树
        if(null != this.right){
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        log.info("后序遍历开始");
        //遍历左子树
        if(null != this.left){
            this.left.postOrder();
        }
        //遍历右子树
        if(null != this.right){
            this.right.postOrder();
        }
        log.info("postOrder = > {}",this);
    }

    /**
     * 前序遍历查找
     * @param no 查找的no
     * @return 返回查找的，找不到返回null
     */
    public HeroNode preOrderSearch(int no){
        log.info("进入前序遍历查找");
        if(no == this.no){
            return this;
        }

        HeroNode heroNode = null;

        if(null != this.left){
            heroNode = this.left.preOrderSearch(no);
        }

        if(!Objects.equals(heroNode,null)){
            //左子树找到了
            return heroNode;
        }

        //如果左子树遍历，没有找到，则遍历右子树
        if(null != this.right){
            heroNode = this.right.preOrderSearch(no);
        }

        return heroNode;
    }

    /**
     * 中序遍历查找
     * @param no 查找的编号
     */
    public HeroNode infixOrderSearch(int no){

        HeroNode heroNode = null;
        //左子树遍历查找
        if(null != this.left){
            heroNode = this.left.infixOrderSearch(no);
        }
        log.info("中序遍历开始");
        if(null != heroNode){
            return heroNode;
        }
        if(no == this.no){
            return this;
        }
        //右子树遍历查找
        if(null != this.right){
            heroNode = this.right.infixOrderSearch(no);
        }
        return heroNode;
    }

    /**
     * 后序遍历查找
     * @param no 目标no
     * @return
     */
    public HeroNode postOrderSearch(int no){
        HeroNode heroNode = null;
        //左子树遍历
        if(null != this.left){
            heroNode = this.left.postOrderSearch(no);
        }

        if(null != heroNode){
            return heroNode;
        }
        //右子树遍历
        if(null != this.right){
            heroNode =this.right.postOrderSearch(no);
        }
        if(null != heroNode){
            return heroNode;
        }

        log.info("后序遍历开始");
        if(no == this.no){
            return this;
        }
        return heroNode;
    }
}
