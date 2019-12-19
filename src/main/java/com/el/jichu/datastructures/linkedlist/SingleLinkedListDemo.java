package com.el.jichu.datastructures.linkedlist;

import java.util.Stack;

/**
 * @author Roman.zhang
 * @Date: 2019/7/10 11:34
 * @Version:V1.0
 * @Description:SingleLinkedListDemo
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        HeroNode hero5 = new HeroNode(5, "吴用", "智多星");
        HeroNode hero6 = new HeroNode(6, "林冲", "豹子头");

        SingleLinkedList linkedList = new SingleLinkedList();

        linkedList.add(hero1);
        linkedList.add(hero2);
        linkedList.add(hero3);
        linkedList.add(hero4);

        //测试下单链表的反转
        System.out.println("原来的链表情况");
        linkedList.list();

        System.out.println(getLength(linkedList.getHead()));
        HeroNode heroNode = reversetList1(linkedList.getHead());
        System.out.println("反转后的链表情况");

        linkedList.list();
        System.out.println("合并后的链表情况");

        System.out.println(linkedList.getNodeByNo(4));
        //该句话造成连接无数数据
        linkedList.getNodeByNo(1).next = heroNode;

        linkedList.list();

        //获得倒数节点
        HeroNode lastNode = findLastNode(linkedList.getHead(), 2);
        System.out.println("节点详情："+lastNode);

        System.out.println("使用栈结构反转元素");
        reversePrint(linkedList.getHead());
    }

    /**
     * 使用stack反转元素
     * @param head
     */
    public static void reversePrint(HeroNode head){
        if(null == head.next){
            return;
        }

        HeroNode cur = head.next;
        Stack<HeroNode> stack = new Stack<>();
        while(null != cur){
            stack.push(cur);
            cur = cur.next;
        }

        while(stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    public static HeroNode findLastNode(HeroNode head,int index){
        if(null == head.next){
            return null;
        }

        //校验长度是否合法
        int size = getLength(head);

        if(index < 0 || index > size){
            System.out.println("index 参数不合法:"+index);
            return null;
        }

        //遍历链表结构
        HeroNode cur = head.next;
        for (int i = 0; i < size - index ; i++) {
            cur = cur.next;
        }

        return cur;

    }

    public static void reversetList(HeroNode heroNode){
        if(null == heroNode.next && null == heroNode.next.next){
            //只有一个或者是空链直接返回
            return;
        }

        HeroNode cur = heroNode.next;
        //声明一个中间变量
        HeroNode next = null;
        //创建一个新的链表
        HeroNode newNode = new HeroNode(0, "", "");

        while(null != cur){
             next = cur.next;
             cur.next = newNode.next;
             newNode.next = cur;
             cur = next;
        }
        heroNode.next = newNode.next;
    }
    public static HeroNode reversetList1(HeroNode heroNode){
        if(null == heroNode.next && null == heroNode.next.next){
            //只有一个或者是空链直接返回
            return null;
        }

        HeroNode cur = heroNode.next;
        //声明一个中间变量
        HeroNode next = null;
        //创建一个新的链表
        HeroNode newNode = new HeroNode(0, "", "");

        while(null != cur){
            //先暂时保存当前节点的下一个节点
            next = cur.next;
            //将cur的下一个节点，放在新链表的最前端
            cur.next = newNode.next;
            //将cur连接到新的链表
            newNode.next = cur;
            //让cur后移
            cur = next;
        }
        //heroNode.next 指向newNode.next
        heroNode.next = newNode.next;
      return   newNode.next;
    }

    public static int getLength(HeroNode head){
        if(null == head.next){
            return 0;
        }
        HeroNode cur =  head.next;
        int length = 0;
        while(null !=cur){
            length++;
            cur = cur.next;
        }
        return length;
    }
}

/**
 * 定义SingleLinkedList
 */
class SingleLinkedList{
    /**
     * 先初始化一个头节点，头节点不要动，不存放具体的数据
     */
  private HeroNode head=  new HeroNode(0, "", "");

    /*public SingleLinkedList(HeroNode head) {
        this.head = head;
    }*/

    /**
     * 返回头节点
     * @return
     */
    public HeroNode getHead() {
        return head;
    }

    /**
     * 默认添加到当前节点的最后节点
     * @param heroNode
     */
    public void add(HeroNode heroNode){
        HeroNode temp = head;

        while(true){
            if(null == temp.next){
                break;
            }
            temp = temp.next;
        }

        temp.next = heroNode;
    }
    public void add1(HeroNode heroNode) {

        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while(true) {
            //找到链表的最后
            if(temp.next == null) {//
                break;
            }
            //如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = heroNode;
    }
    /**
     * 根据排名插入到指定位置
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode){
        //flag 标志添加的编号是否存在，默认为false
        boolean flag =  false;
        HeroNode temp = head;

        while(true){
            if(null == temp.next){
                break;
            }
            if(temp.next.no > heroNode.no){
                break;
            }else if(temp.next.no == heroNode.no){
                //该编号存在
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            System.out.printf("准备插入的英雄的编号 %d 已经存在，不能插入",heroNode.no);
        }else{
            //插入节点位置指向指针所在的下一个节点
            heroNode.next = temp.next;
            //指针节点位置的下一个指向，待插入节点
            temp.next = heroNode;
        }
    }

    /**
     * 修改指定节点
     * @param heroNode
     */
    public void update(HeroNode heroNode){
        if(null == head.next){
            System.out.println("链表为空--");
            return;
        }
        //是否找到对应节点
        boolean flag = false;

        HeroNode temp = head.next;

        while(true){
            if(null == temp){
                break;
            }
            if(temp.no == heroNode.no){
                //找到对应节点
                flag =  true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else{
            System.out.printf("没有找到对应编号 %d 的节点，不能修改\n",heroNode.no);
        }
    }

    /**
     * 删除节点
     * @param no：节点编号
     */
    public void del(int no){
        boolean flag = false;

        HeroNode temp = head;

        while(true){
            if(null == temp.next){
                break;
            }
            if(no == temp.next.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.printf("没有找到编号 %d 的节点",no);
        }
    }

    /**
     * 根据节点编号获取节点信息
     * @param no
     * @return
     */
    public HeroNode getNodeByNo(int no){
        HeroNode temp = head;

        while(true){
            if(null == temp){
                break;
            }
            if(no == temp.no){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 遍历链表
     */
    public void list(){
        if(null == head.next){
            System.out.printf("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while(true){
            if(null == temp ){
                break;
            }
            HeroNode nodeByNo = getNodeByNo(temp.no);
            System.out.println("编号："+nodeByNo.no+"  姓名："+nodeByNo.name+"  昵称："+
                    nodeByNo.nickName);
            temp = temp.next;
        }
    }
    //显示链表[遍历]
    public void list1() {
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while(true) {
            //判断是否到链表最后
            if(temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移， 一定小心
            temp = temp.next;
        }
    }
}
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
