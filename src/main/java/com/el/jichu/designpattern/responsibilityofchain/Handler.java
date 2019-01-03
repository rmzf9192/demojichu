package com.el.jichu.designpattern.responsibilityofchain;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 15:30
 * @Version:V1.0
 * @Description:Handle
 *  Abstracthandler 类提供了 get和 set 方法，方便MyHandle 类设置和修改引用对象，
 *  MyHandle 类是核心，实例化后生成一系列相互持有的对象，构成一条链。
 */
public interface Handler {

    public void operator();
}
