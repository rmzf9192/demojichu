package com.el.jichu.designpattern.facade;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/27 20:54
 * @Version:V1.0
 * @Description:User 如果我们没有 Computer 类，那么，CPU、Memory、Disk 他们之间将会相互持有实例，产
 * 生关系，这样会造成严重的依赖，修改一个类，可能会带来其他类的修改，这不是我们想要
 * 看到的，有了 Computer 类，他们之间的关系被放在了 Computer 类里，这样就起到了解耦 的作用，这，就是外观模式！
 */
public class User {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}
