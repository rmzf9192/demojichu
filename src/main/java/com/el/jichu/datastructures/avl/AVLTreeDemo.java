package com.el.jichu.datastructures.avl;

/**
 * @author Roman.zhang
 * @Date: 2019/7/30 9:37
 * @Version:V1.0
 * @Description:AVLTreeDemo
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
//int[] arr = {4,3,6,5,7,8};
        //int[] arr = { 10, 12, 8, 9, 7, 6 };
        int[] arr = { 10, 11, 7, 6, 8, 9 };
        //创建一个 AVLTree对象
        AVLTree avlTree = new AVLTree();
        //添加结点
        for(int i=0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        //遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();

        System.out.println("在平衡处理~~");
        System.out.println("树的高度=" + avlTree.getRoot().height()); //3
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight()); // 2
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight()); // 2
        System.out.println("当前的根结点=" + avlTree.getRoot());//8
    }
}

/**
 * 创建AVL树
 */
class AVLTree{
    private Node root;

    public Node getRoot() {
        return root;
    }

    /**
     * 查找当前节点
     * @param value
     * @return
     */
    public Node search(int value){
        if(null == root){
            return null;
        }else{
            return root.search(value);
        }
    }

    /**
     * 当前节点的父节点
     * @param value
     * @return
     */
    public Node searchParent(int value){
        if(null == root){
            return null;
        }else{
            return root.searchParent(value);
        }
    }

    /**
     * 返回，以node为根节点的二叉树的最小节点的值
     * @param node
     * @return
     */
    public int delRightTreeMin(Node node){
        Node target = node;

        if(null != target.left){
            target = target.left;
        }

        delNode(target.value);
        return target.value;
    }

    public void delNode(int value){
        if(null == root){
            return;
        }else{
            Node target = search(value);

            if(target == null){
                return;
            }
            if(null == root.left && null == root.right){
                root = null;
                return;
            }

            //找到当前节点的父节点
            Node parent = searchParent(value);
            //删除的节点是叶子节点
            if(null == target.left && null == target.right){
                if(null !=parent.left && parent.left.value == value){
                    parent.left = null;
                }else if(null != parent.right && parent.right.value == value){
                    parent.right = null;
                }
            }else if(null != target.left && null != target.right){
                int minVal = delRightTreeMin(target.right);
                target.value = minVal;
            }else{
                if(null != target.left){
                    if(parent != null){
                        if(value == parent.left.value){
                            parent.left = target.left;
                        }else{
                            parent.right = target.left;
                        }
                    }else{
                        root = target.left;
                    }
                }else{
                    if(parent !=null){
                        if(value == parent.left.value){
                            parent.left = target.right;
                        }else{
                            parent.right = target.right;
                        }
                    }else{
                        root = target.right;
                    }
                }
            }
        }
    }

    public void add(Node node){
        if(null == root){
            root = node;
        }else{
            root.add(node);
        }
    }

    public void infixOrder(){
        if(null != root){
            root.infixOrder();
        }else{
            System.out.println("平衡二叉树为空，不能遍历");
        }
    }
}


/**
 * 创建节点
 */
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
     * 获取左子树高度
     * @return
     */
    public int leftHeight(){
        if(null == left){
            return 0;
        }
        return left.height();
    }

    public int rightHeight(){
        if(null == right){
            return 0;
        }
        return right.height();
    }


    /**
     * 获取根节点的高度
     * @return
     */
    public int height(){
        return Math.max(left == null ? 0 :left.height(),right == null ? 0 : right.height())+1;
    }

    /**
     * 左旋转
     */
    public void leftRoate(){
        //创建新的节点，以当前根节点的值
        Node newNode = new Node(value);
        //把新节点的左子树设置为当前节点的左子树
        newNode.left = left;
        // 把新节点的右子树设置为之前根节点的右子树的左子树
        newNode.right = right.left;
        //把当前节点的值换为右子节点的值
        value = right.value;
        //把当前根节点的右子树设置为右子树的右子树
        right = right.right;
        //把当前节点的左子树设置为新的节点
        left = newNode;
    }

    /**
     * 右旋转
     */
    public void rightRoate(){
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = right.left;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    /**
     * 根据值获得节点
     * @param value
     * @return
     */
    public Node search(int value){
        if(value == this.value){
            return this;
        }else if(value < this.value){
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
     * 查找到节点值的父节点
     * @param value
     * @return
     */
    public Node searchParent(int value){
        if((null != this.left && value == this.left.value) ||
            (null != this.right && value == this.right.value)){
            return this;
        }else if(value < this.value && null != this.left){
            return this.left.searchParent(value);
        }else if(value >= this.value && null != this.right){
            return this.right.searchParent(value);
        }else{
            return null;
        }
    }

    public void infixOrder(){
        if(null != this.left){
            this.left.infixOrder();
        }
        System.out.println(this);

        if(null != this.right){
            this.right.infixOrder();
        }
    }

    /**
     * 添加节点
     * @param node
     */
    public void add(Node node){
        if(null == node){
            return;
        }

        if(node.value < this.value){
            if(null == this.left){
                this.left = node;
            }else{
                this.left.add(node);
            }
        }else{
            if(null == this.right){
                this.right = node;
            }else{
                this.right.add(node);
            }
        }

        //当添加一个节点后，如果右子树高度大于左子树高度，则左旋
        if(rightHeight() -leftHeight() > 1){
            //如果右子树的左子树的高度大于右子树的右子树高度
            if(null != right && right.leftHeight() > right.rightHeight()){
                //右节点右旋
                right.rightRoate();
                //左旋
                leftRoate();
            }else{
                leftRoate();
            }
            return;
        }

        if(leftHeight() - rightHeight() > 1){
            //左子树的右子树导读大于左子树的左子树高度
            if(null != left && left.rightHeight() > left.leftHeight()){
                //先左旋
                left.leftRoate();
                //右旋
                rightRoate();
            }else{
                rightRoate();
            }
           // return;
        }
    }
}
