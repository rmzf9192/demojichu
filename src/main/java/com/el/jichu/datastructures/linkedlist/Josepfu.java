package com.el.jichu.datastructures.linkedlist;

/**
 * @author Roman.zhang
 * @Date: 2019/7/11 17:21
 * @Version:V1.0
 * @Description:Josepu
 */
public class Josepfu {
}

class CircleSingleLinkedList{
    public static void main(String[] args) {

        CircleSingleLinked circleSingleLinked = new CircleSingleLinked();
        circleSingleLinked.createCircleBoy(5);

        System.out.println("遍历当前单向链表");
        circleSingleLinked.list();
        System.out.println("小孩子出圈顺序"); //2->4->1->5->3
        circleSingleLinked.countBoy(1,2,5);
    }
}

class CircleSingleLinked{
    // 创建一个头节点，且不赋予编号
    private Boy first = null;

    /**
     * 创建环形链表
     * @param nums 环形链表的长度
     */
    public void createCircleBoy(int nums){
        // 校验数据
        if(nums < 1){
            System.out.println("环形链表长度小于："+nums);
            return;
        }

        //创建辅助指针
        Boy curBoy =  null;

        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if(1 == i){
                first = boy;
                curBoy = first;
                boy.setNext(first);
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }

    }

    /**
     *遍历当前链表
     */
    public void list(){
        if(null == first){
            System.out.println("当前链表为空");
            return;
        }

        //创建辅助指针
        Boy curBoy = first;
        while (true) {
            System.out.println("当前孩子的编号："+curBoy.getNo());
            if(curBoy.getNext() ==  first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }


    /**
     * 按照一定的顺序，计算出小孩出圈是顺序
     * @param startNo 从第几个开始数
     * @param countNum 数几个孩子出圈
     * @param nums 链表结构长度
     */
    public void countBoy(int startNo ,int countNum,int nums){
        // 校验数据
        if(null == first || startNo < 1 || startNo > nums){
            System.out.println("参数有误");
            return;
        }

        //创建辅助指针，并指向最后一个节点
        Boy curBoy = first;

        while (true) {
            if (curBoy.getNext() == first ){
                break;
            }
            curBoy = curBoy.getNext();
        }

        //小孩报数前，先移动startNo - 1
        for (int i = 0; i < startNo -1; i++) {
            first = first.getNext();
            curBoy = curBoy.getNext();
        }

        while (true) {
            if(curBoy == first){
                System.out.println("只有一个节点");
                break;
            }

            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                curBoy = curBoy.getNext();
            }
            System.out.printf("小孩子%d出圈顺序：",first.getNo());

            //helper GC remove
            first = first.getNext();
            curBoy.setNext(first);
        }

        System.out.println("最后留在圈里的小孩编号："+first.getNo());

    }
}


class Boy{
  private int no;
  private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
