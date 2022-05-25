package com.el.jichu.designpattern.interpreter.test;

import java.util.HashMap;

/**
 * @author Roman.zhang
 * @Date: 2019/7/12 16:12
 * @Version:V1.0
 * @Description:mulityExpression
 */
public class mulityExpression extends SymbolExpression {

    public mulityExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var){
        return super.left.interpreter(var) * super.right.interpreter(var);
    }
}
