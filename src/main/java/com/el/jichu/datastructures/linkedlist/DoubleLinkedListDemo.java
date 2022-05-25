package com.el.jichu.datastructures.linkedlist;

/**
 * @author Roman.zhang
 * @Date: 2019/7/10 17:32
 * @Version:V1.0
 * @Description:DoubleLinkedListDemo
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
// 测试
        System.out.println("双向链表的测试");
        // 先创建节点
        DoubleNode hero1 = new DoubleNode(1, "宋江", "及时雨");
        DoubleNode hero2 = new DoubleNode(2, "卢俊义", "玉麒麟");
        DoubleNode hero3 = new DoubleNode(3, "吴用", "智多星");
        DoubleNode hero4 = new DoubleNode(4, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        // 修改
        DoubleNode newHeroNode = new DoubleNode(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表情况~~");
        doubleLinkedList.list();

    }
}
class DoubleLinkedList{
    private DoubleNode head = new DoubleNode(0,"","");

    public DoubleNode getHead() {
        return head;
    }

    public void list(){
        if(null == head.next){
            //空链表
            return;
        }
        DoubleNode temp = head.next;

        while(null !=temp){
            System.out.println("jjj:"+temp);
            temp = temp.next;
        }

        while(true){
            if(null == temp){
                break;
            }
            System.out.println("true:"+temp);
            temp = temp.next;
        }
    }

    public void add(DoubleNode doubleNode){
        DoubleNode temp = head;

        while(true){
            if(null == temp.next){
                break;
            }
            temp = temp.next;
        }
        temp.next = doubleNode;
        doubleNode.pre = temp;
    }

    public void update(DoubleNode doubleNode){
        if(null == head.next){
            System.out.println("链表为空");
            return;
        }
        DoubleNode temp = head.next;
        boolean flag = false;
        while(true){
            if(null == temp){
                break;
            }
            if(doubleNode.no == temp.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.name = doubleNode.name;
            temp.nickName = doubleNode.nickName;
        }else{
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", doubleNode.no);
        }
    }

    public void del(int no){
        if(null == head.next){
            System.out.println("链表为空");
            return;
        }
        DoubleNode temp =  head.next;

        boolean flag = false;
        while(true){
            if(null == temp){
                break;
            }
            if(temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.pre.next = temp.next;

            if(null !=temp.next){
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }
}
// 定义一个节点
class DoubleNode{
    public int no;
    public String name;
    public String nickName;
    public DoubleNode next;
    public DoubleNode pre;

    public DoubleNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
