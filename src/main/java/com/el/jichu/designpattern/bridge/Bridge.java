package com.el.jichu.designpattern.bridge;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/28 9:01
 * @Version:V1.0
 * @Description:Bridge
 *   定义一个抽象类，持有Sourceable的一个实例
 */
public abstract class Bridge  {
    private Sourceable sourceable;

    public Sourceable getSourceable() {
        return sourceable;
    }

    public void setSourceable(Sourceable sourceable) {
        this.sourceable = sourceable;
    }

    public void method(){
        sourceable.method();
    }
}
