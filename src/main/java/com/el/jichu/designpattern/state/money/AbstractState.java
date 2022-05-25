package com.el.jichu.designpattern.state.money;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 11:06
 * @Version:V1.0
 * @Description:AbstractState
 */
public abstract class AbstractState implements State {
    protected static RuntimeException EXCEPTION = new RuntimeException("操作流程不允许");


    public void checkEvent(Context context) {
        throw EXCEPTION;
    }

    public void checkFailEvent(Context context) {
        throw EXCEPTION;
    }

    public void makePriceEvent(Context context) {
        throw EXCEPTION;
    }

    public void acceptOrderEvent(Context context) {
        throw EXCEPTION;
    }

    public void notPeopleAcceptEvent(Context context) {
        throw EXCEPTION;
    }

    public void payOrderEvent(Context context) {
        throw EXCEPTION;
    }

    public void orderFailureEvent(Context context) {
        throw EXCEPTION;
    }

    public void feedBackEvent(Context context) {
        throw EXCEPTION;
    }
}
