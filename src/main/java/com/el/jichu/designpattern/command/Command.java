package com.el.jichu.designpattern.command;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 16:07
 * @Version:V1.0
 * @Description:Command Invoker 是调用者（司令员），Receiver 是被调用者（士兵），，实现 了 Command 接口，持有接收对象
 */
public interface Command {
    void exe();
}
