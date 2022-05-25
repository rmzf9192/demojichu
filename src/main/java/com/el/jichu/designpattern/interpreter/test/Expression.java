package com.el.jichu.designpattern.interpreter.test;

import java.util.HashMap;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 11:28
 * @Version:V1.0
 * @Description:Expression
 */
public abstract class Expression {

    public abstract int interpreter(HashMap<String,Integer> var);

}
