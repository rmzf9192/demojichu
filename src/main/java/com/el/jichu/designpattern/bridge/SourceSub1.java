package com.el.jichu.designpattern.bridge;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/28 8:59
 * @Version:V1.0
 * @Description:SourceSub1:实现Sourceable接口
 */
public class SourceSub1 implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is the Sourceable1");
    }
}
