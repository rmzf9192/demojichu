package com.el.jichu.designpattern.proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/12 9:29
 * @Version:V1.0
 * @Description:DynaProxyHello
 *   动态代理
 */
public class DynaProxyHello implements InvocationHandler {
    private Object object;

    public Object bind(Object object){
        this.object=object;
        return Proxy.newProxyInstance(this.object.getClass().getClassLoader(),this.object.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        Logger.start();
        //通过反射创建目标方法
        result=method.invoke(this.object,args);
        Logger.end();
        return result;
    }
}
