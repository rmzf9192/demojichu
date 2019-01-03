package com.el.jichu.designpattern.state;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 16:42
 * @Version:V1.0
 * @Description:Context
 * Context 类可以实现切换
 */
public class Context {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Context(State state) {
        this.state = state;
    }

    public void method(){
        if(state.getValue().equals("state1")){
            state.method1();
        }else if(state.getValue().equals("state2")){
            state.method2();
        }
    }
}
