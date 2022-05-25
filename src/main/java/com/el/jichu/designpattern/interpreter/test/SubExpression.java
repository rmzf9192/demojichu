package com.el.jichu.designpattern.interpreter.test;

import java.util.HashMap;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 11:34
 * @Version:V1.0
 * @Description:SubExpression
 */
public class SubExpression extends SymbolExpression {


    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String,Integer> var){
        System.out.println( super.left.interpreter(var));;
        System.out.println( super.right.interpreter(var));;
        return super.left.interpreter(var)-super.right.interpreter(var);
    }
}
