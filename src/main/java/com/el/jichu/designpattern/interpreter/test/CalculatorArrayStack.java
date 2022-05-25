package com.el.jichu.designpattern.interpreter.test;


import com.el.jichu.datastructures.stack.ArrayStack2;

/**
 * @author Roman.zhang
 * @Date: 2019/7/12 16:17
 * @Version:V1.0
 * @Description:CalculatorArrayStack
 */
public class CalculatorArrayStack {

    public static void main(String[] args) {
        //定义两个栈，分别存储数值和符号
        String expression = "7*2*2-5+1-5+3-4";

        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);


        //定义待使用的变量
        // 用于扫描
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int res = 0;


    }
}
