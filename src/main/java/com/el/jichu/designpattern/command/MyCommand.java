package com.el.jichu.designpattern.command;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 16:08
 * @Version:V1.0
 * @Description:MyCommand:命令
 */
public class MyCommand implements Command {
    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}
