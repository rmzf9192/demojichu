package com.el.jichu.designpattern.bridge;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/28 8:57
 * @Version:V1.0
 * @Description:Source:实现Sourceable接口
 */
public class SourceSub2 implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is the two SourceSub2");
    }
}
