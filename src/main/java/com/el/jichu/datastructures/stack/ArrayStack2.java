package com.el.jichu.datastructures.stack;

/**
 * @author Roman.zhang
 * @Date: 2019/7/12 16:19
 * @Version:V1.0
 * @Description:ArrayStack2
 */
public class ArrayStack2 {
    private int top = -1; // 栈顶位置 初始化为-1
    private int[] stack; // 数组 存储栈数据，
    private int maxSize; // 栈大小

    /**
     * 使用构造器，初始化栈顶
     * @param maxSize
     */
    public ArrayStack2(int maxSize) {
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
     * 返回当前栈顶数据
     * @return
     */
    public int peek(){
        return stack[top];
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

    /**
     * 判断是符号还是数字
     * @param val
     * @return
     */
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }


    /**
     * 获取对应符号的优先级
     * @param oper
     * @return
     */
    public int priority(int oper){
        if('*' == oper || '/' == oper){
            return 1;
        }else if ('+' == oper || '-' == oper){
            return 0;
        }else {
            return -1;
        }
    }

    public int calculator (int num1,int num2,int oper){
        int value = 0;
        switch (oper){
            case '+':
                value = num1 + num2;
                break;
            case '-':
                value = num2 - num1;
                break;
            case '/':
                value = num2 / num1;
                break;
            case '*':
                value = num1 * num2;
                break;
            default:
                break;
        }
        return value;
    }
}
