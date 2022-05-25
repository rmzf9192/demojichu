package com.el.jichu.designpattern.visitor.test;

/**
 * @author roman zhangfei
 * @Date 2019/12/18 17:28
 * @Version V1.0
 */
public class Wait extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println(" 男人给的评价是该歌手待定 ..");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println(" 男人给的评价是该歌手待定 ..");
    }
}