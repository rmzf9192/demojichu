package com.el.jichu.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/4 15:11
 * @Version:V1.0
 * @Description:TestReflex 反射就是在运行时才知道要操作的类是什么，并且可以在运行时获取类的完整构造，并调用对应的方法。
 */

public class TestReflex {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Person xiao = new Person();
        xiao.setAge(21);
        xiao.setName("jj");
        System.out.println("person:" + xiao);
        //使用jdk提供的反射的API
        Class aClass = Class.forName("com.el.jichu.reflex.Person");
        Method method = aClass.getMethod("setName", String.class);
        Method method1 = aClass.getMethod("setAge", Integer.class);
        Object o = aClass.newInstance();
        Constructor constructor = aClass.getConstructor();
        Object instance = constructor.newInstance();
        method.invoke(instance, "lisi");
        method1.invoke(instance, 23);
        Object zhangsan = method.invoke(o, "zhangsan");
        Object invoke = method1.invoke(o, 23);
        System.out.println("Person:" + instance);
    }
}

