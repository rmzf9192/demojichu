package com.el.jichu.designpattern.command;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 16:12
 * @Version:V1.0
 * @Description:TestCommand 这个很哈理解，命令模式的目的就是达到命令的发出者和执行者之间解耦，实现请求和执行
 * 分开，熟悉 Struts 的同学应该知道，Struts 其实就是一种将请求和呈现分离的技术，其中必 然涉及命令模式的思想
 */
public class TestCommand {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        MyCommand myCommand = new MyCommand(receiver);

        Invoker invoker = new Invoker(myCommand);
        invoker.action();
    }
}
