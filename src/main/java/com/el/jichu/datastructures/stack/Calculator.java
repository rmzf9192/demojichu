package com.el.jichu.datastructures.stack;

/**
 * @author Roman.zhang
 * @Date: 2019/7/12 15:13
 * @Version:V1.0
 * @Description:Calculator
 */
public class Calculator {
    public static void main(String[] args) {
        //String expression = "7*2*2-5+1-5+3-4";
        String expression = "13+2*6-2";

        //创建两个栈
        //数字栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        //定义相关变量
        //用于变量
        int index = 0 ;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res =0;
        char ch = ' ';
        //用于拼接多为数字
        String keepNum = "";

        while(true){
            //依次获取每个字符
            ch = expression.substring(index,index+1).charAt(0);

                if(operStack.isOper(ch)){
                    //判断符号是否为空
                    if(!operStack.isEmpty()){
                        //符号，判断符号的优先级
                        if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                            num1 = numStack.pop();
                            num2 = numStack.pop();
                            oper = operStack.pop();

                            res = numStack.calculator(num1,num2,oper);

                            //把结果保存到数栈
                            numStack.push(res);
                            //把当前栈保存到符号栈
                            operStack.push(ch);
                        }else{
                            operStack.push(ch);
                        }
                    }else{
                        operStack.push(ch);
                    }

                }else{ //是数
                    keepNum+=ch;
                    if(index == expression.length()-1){
                        numStack.push(Integer.parseInt(keepNum));
                    }else{
                        if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                            numStack.push(Integer.parseInt(keepNum));
                            keepNum = "";
                        }
                    }
                }

                index++;
                if(index >= expression.length()){
                    break;
                }
        }
        while(true){
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.calculator(num1,num2,oper);

            numStack.push(res);
        }
        int sum = numStack.pop();
        System.out.printf("表达式 %s = %d", expression, sum);
    }

}

/*class ArrayStack2{

}*/
