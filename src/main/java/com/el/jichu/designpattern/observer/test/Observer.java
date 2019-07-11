package com.el.jichu.designpattern.observer.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 15:16
 * @Version:V1.0
 * @Description:Observer
 */
public interface Observer {

    public void update(float temperature,float pressure,float humidity);
}
