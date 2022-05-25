package com.el.jichu.datastructures.queue;

import java.util.Scanner;

/**
 * @author Roman.zhang
 * @Date: 2019/7/10 10:16
 * @Version:V1.0
 * @Description:ArrayQueue  使用数组模拟一个队列
 */
public class ArrayQueue {
    //队列最大容量
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;



    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        this.arr =new int[maxSize];
    }

    public boolean isFull(){
        return rear == maxSize - 1;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public void add(int n){
        if(isFull()){
            System.out.println("队列已经满了，不能在加入");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    /**
     * 获取队列的值
     * @return
     */
    public int getQueue() {
        if(isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，显示");
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("arr%d=%d\n",i,arr[i]);
        }
    }
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        return arr[front+1];
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);

        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int i = scanner.nextInt();
                    arrayQueue.add(i);
                    break;
                case 'g':
                    int queue = arrayQueue.getQueue();
                    System.out.printf("取出的数据是%d\n",queue);
                    break;
                case 'h':
                    int i1 = arrayQueue.headQueue();
                    System.out.printf("头队列的值是%d\n",i1);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                 default:
                     break;
            }
        }
        System.out.println("程序退出");
    }
}
