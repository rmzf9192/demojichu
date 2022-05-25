package com.el.jichu.designpattern.interpreter;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 17:28
 * @Version:V1.0
 * @Description:Plus
 */
public class Plus implements Expression {
    @Override
    public int interpret(Context context) {
        return context.getNum1() + context.getNum2();
    }
}
