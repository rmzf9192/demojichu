package com.el.jichu.designpattern.proxy.aop;

import com.el.jichu.designpattern.mediator.Mediator;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/12 9:54
 * @Version:V1.0
 * @Description:DynaLogger
 */
public class DynaLogger implements ILogger {
    @Override
    public void start(Method method) {
        System.out.println(LocalDateTime.now()+",,"+method.getName()+"dynaLogger start is runing");
    }

    @Override
    public void end(Method method) {
        System.out.println(LocalDateTime.now()+",,"+method.getName()+"dynaLogger start is runing");
    }
}
