package com.el.jichu.designpattern.state.money;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 11:14
 * @Version:V1.0
 * @Description:ClientTest
 */
public class ClientTest {
    public static void main(String[] args) {
        Context context = new Context();

        context.setState(new PublishState());
        System.out.println(context.getCurrentState());

        context.acceptOrderEvent(context);

        context.payOrderEvent(context);
    }
}
