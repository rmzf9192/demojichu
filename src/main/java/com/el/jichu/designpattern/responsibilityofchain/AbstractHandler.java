package com.el.jichu.designpattern.responsibilityofchain;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 15:35
 * @Version:V1.0
 * @Description:AbstractHandler
 */
public abstract class AbstractHandler {

    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
