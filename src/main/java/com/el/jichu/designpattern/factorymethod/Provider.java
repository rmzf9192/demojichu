package com.el.jichu.designpattern.factorymethod;

import com.el.jichu.designpattern.simplefactory.Sender;

public interface Provider {
    public Sender produce();
}
