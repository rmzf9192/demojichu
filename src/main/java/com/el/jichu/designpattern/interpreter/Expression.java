package com.el.jichu.designpattern.interpreter;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 17:25
 * @Version:V1.0
 * @Description:Expression
 */
public interface Expression {

    public int interpret(Context context);
}
