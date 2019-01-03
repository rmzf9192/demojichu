package com.el.jichu.designpattern.memento;

import java.util.Scanner;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 16:32
 * @Version:V1.0
 * @Description:TestMemento
 *
 * 新建原始类时，value 被初始化为egg，后经过修改，将 value 的值置为 niu，
 * 最后倒数第二行进行恢复状态，结果成功恢复了。其实我觉得这个模式叫“备份-恢复”模式最 形象。
 */
public class TestMemento {
    public static void main(String[] args) {
        //创建原始类
        Original egg = new Original("egg");

        //创建备忘录类
        Storage storage = new Storage(egg.createMemento());

        //修改原始状态
        System.out.println("原始状态："+egg.getValue());
        egg.setValue("niu");
        System.out.println("修改后的状态："+egg.getValue());

        //恢复原始状态
        egg.restoreMemento(storage.getMemento());

        System.out.println("恢复后的状态："+egg.getValue());
    }
}
