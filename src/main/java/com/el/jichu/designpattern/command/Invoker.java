package com.el.jichu.designpattern.command;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 16:11
 * @Version:V1.0
 * @Description:Invoker:调用者（司令员）
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.exe();
    }
}
