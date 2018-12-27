package com.el.jichu.daoImpl;

import com.el.jichu.dao.JDK8Interface;

public class JDK8Impl implements JDK8Interface {

    //实现接口后，因为默认方法不是抽象方法，所以可以不重写，但是如果开发需要，也可以重写

    public void defaultMethod(){
        System.out.println("接口实现类中的方法覆盖掉接口中的默认方法");
    }
}
