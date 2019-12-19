package com.el.jichu.designpattern.proxy.aop;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/12 9:51
 * @Version:V1.0
 * @Description:DynaProxyLoggerHello
 *    动态代理解耦
 */
public class DynaProxyLoggerHello implements InvocationHandler {
    private Object proxy;
    private Object object;

    public Object bind(Object object,Object proxy){
        this.object=object;
        this.proxy=proxy;
        return Proxy.newProxyInstance(this.object.getClass().getClassLoader(),
                this.object.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        //通过反射获取到操作者实例
        Class aClass =this.proxy.getClass();
        //通过实例执行方法
        Method start = aClass.getDeclaredMethod("start", new Class[]{Method.class});
        //反射执行start方法
        start.invoke(this.proxy,new Object[]{start});
        //反射执行原来的方法
        result=method.invoke(this.object,args);
        //通过实例获取执行方法
        Method end = aClass.getDeclaredMethod("end", new Class[]{Method.class});
        //反射执行end方法
        end.invoke(this.proxy,new Object[]{end});
        return result;
    }
}
