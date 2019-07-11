package com.el.jichu.designpattern.state.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 10:53
 * @Version:V1.0
 * @Description:Client
 */
public class Client {
    public static void main(String[] args) {
        RaffleActivity raffleActivity = new RaffleActivity(1);

        for (int i = 0; i <30 ; i++) {
            System.out.println("-----第"+(i+1)+"次，抽奖");

            raffleActivity.debuctMoney();

            raffleActivity.raffle();
        }
    }
}
