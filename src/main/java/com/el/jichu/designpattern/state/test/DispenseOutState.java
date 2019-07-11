package com.el.jichu.designpattern.state.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 10:45
 * @Version:V1.0
 * @Description:DispenseOutState
 */
public class DispenseOutState extends State {
    RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("奖品发送完了，请下次在参加");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品发送完了，请下次在参加");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发送完了，请下次在参加");
    }
}
