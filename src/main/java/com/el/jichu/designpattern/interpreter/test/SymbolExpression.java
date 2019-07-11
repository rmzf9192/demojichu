package com.el.jichu.designpattern.interpreter.test;

import java.util.HashMap;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 11:33
 * @Version:V1.0
 * @Description:SymbolExpression
 */
public class SymbolExpression extends Expression {
    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return 0;
    }
}
