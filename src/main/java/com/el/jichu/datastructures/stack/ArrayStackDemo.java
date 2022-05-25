package com.el.jichu.datastructures.stack;

import java.util.Scanner;

/**
 * @author Roman.zhang
 * @Date: 2019/7/12 14:07
 * @Version:V1.0
 * @Description:ArrayStackDemo 使用数组模拟栈
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";

        //控制是否退出菜单
        boolean flag = true ;
        Scanner scanner = new Scanner(System.in);
        while(flag) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数字");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    int popv = stack.pop();
                    System.out.println("出栈的值："+popv);
                    break;
                case "exit":
                    scanner.close();
                    flag = false;
                    break;
                 default:
                     break;
            }
        }
        System.out.println("程序退出");
    }
}


class ArrayStack {
    private int top = -1; // 栈顶位置 初始化为-1
    private int[] stack; // 数组 存储栈数据，
    private int maxSize; // 栈大小

    /**
     * 使用构造器，初始化栈顶
     * @param maxSize
     */
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }

    /**
     * 判断栈是否满
     * @return
     */
    public boolean isFull(){
        return top == maxSize - 1;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 入栈
     * @param value
     */
    public void push(int value) {
        if(isFull()){
            throw new RuntimeException("栈已满，不能在入栈");
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈
     */
    public int pop(){
        if(isEmpty()) {
            throw new RuntimeException("栈为空，不能再出栈");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 遍历栈
     */
    public void list(){
        if(isEmpty()){
            throw  new RuntimeException("栈为空，不能遍历");
        }
        //从栈顶到栈低
        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
