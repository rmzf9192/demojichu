package com.el.jichu.designpattern.visitor.test;

/**
 * @author roman zhangfei
 * @Date 2019/12/18 17:27
 * @Version V1.0
 */
public class Fail extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println(" 男人给的评价该歌手失败 !");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println(" 女人给的评价该歌手失败 !");
    }
}