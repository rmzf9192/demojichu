package com.el.jichu.designpattern.interpreter;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 17:30
 * @Version:V1.0
 * @Description:TestInterpreTer 基本就这样，解释器模式用来做各种各样的解释器，如正则表达式等的解释器等等
 */
public class TestInterpreTer {

    public static void main(String[] args) {
        //计算9+2-8

        int interpret = new Minus().interpret(new Context(new Plus().interpret(new Context(9, 2)), 8));

        System.out.println(interpret);
    }
}
