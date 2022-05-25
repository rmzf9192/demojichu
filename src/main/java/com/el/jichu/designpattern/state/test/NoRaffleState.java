package com.el.jichu.designpattern.state.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 10:36
 * @Version:V1.0
 * @Description:NoRaffleState  不能抽奖的状态
 */
public class NoRaffleState extends State {
    RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("扣除50积分成功，你可以抽奖了");
        activity.setState(activity.getCanRaffleState());
    }

    @Override
    public boolean raffle() {
        System.out.println("扣了积分才能抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品");
    }
}
