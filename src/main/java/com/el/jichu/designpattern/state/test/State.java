package com.el.jichu.designpattern.state.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 10:33
 * @Version:V1.0
 * @Description:State
 */
public abstract class State {
    // 扣除积分 - 50
    public abstract void deductMoney();

    // 是否抽中奖品
    public abstract boolean raffle();

    // 发放奖品
    public abstract  void dispensePrize();
}
