package com.el.jichu.domain;

import com.el.jichu.test.MyFun;
import com.el.jichu.test.MyInterface;

public class SubClass  implements MyFun, MyInterface {
    @Override
    public String getName() {
        return MyInterface.super.getName();
    }
}
