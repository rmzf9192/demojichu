package com.el.jichu.datastructures.queue;

import java.util.Scanner;

/**
 * @author Roman.zhang
 * @Date: 2019/7/10 11:06
 * @Version:V1.0
 * @Description:CircleArray
 */
public class CircleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void add(int i){
        if(isFull()){
            System.out.printf("队列满了，不能添加");

            return;
        }
        arr[rear] = i;
        rear = (rear+1) % maxSize;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int value = arr[front];
        front = (front+1) % maxSize;
        return value;
    }
    public void showQueue(){
        if(isEmpty()){
            System.out.printf("队列为空，没有元素");
            return;
        }
        for (int i = front; i < front+size() ; i++) {
            System.out.printf("arr[%d] = %d\n",i % maxSize,arr[i % maxSize]);
        }

    }

    public int size(){
        return (rear+maxSize-front) % maxSize;
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }

    public static void main(String[] args) {
        //测试一把
        System.out.println("测试数组模拟环形队列的案例~~~");

        // 创建一个环形队列
        CircleArray queue = new CircleArray(4); //说明设置4, 其队列的有效数据最大是3
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}
