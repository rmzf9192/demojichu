package com.el.jichu.designpattern.state.test;

import java.util.Random;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 10:41
 * @Version:V1.0
 * @Description:CanRaffleState  可以抽奖的状态
 */
public class CanRaffleState extends State {
    RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("已经扣取过了积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("正在抽奖，请稍等");
        Random r = new Random();
        int num = r.nextInt(10);
        if(num == 0){
            activity.setState(activity.getDispenseState());
            return true;
        }else{
            System.out.println("很遗憾没有抽取到奖品");
            activity.setState(activity.getNoRafflleState());
            return false;
        }

    }

    @Override
    public void dispensePrize() {
        System.out.println("很遗憾，不能发放奖品");
    }
}
