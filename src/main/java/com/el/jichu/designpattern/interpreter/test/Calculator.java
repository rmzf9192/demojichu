package com.el.jichu.designpattern.interpreter.test;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 11:41
 * @Version:V1.0
 * @Description:Calculator
 */
public class Calculator {

    private Expression expression;

    public Calculator(String expStr) {
        Stack<Expression> stack = new Stack();


        char[] charArray = expStr.toCharArray();

        Expression left = null;
        Expression right = null;

        for (int i = 0; i <charArray.length ; i++) {
            switch (charArray[i]){
                case '+':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left,right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left,right));
                    break;
               /* case '*':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new mulityExpression(left,right));*/
                 default:
                     stack.push(new VarExpression(String.valueOf(charArray[i])));
                     break;
            }
        }
        this.expression= stack.pop();
    }

    public int run(HashMap<String,Integer> var){
        return this.expression.interpreter(var);
    }
}
