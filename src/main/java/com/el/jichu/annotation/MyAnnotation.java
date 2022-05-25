package com.el.jichu.annotation;

import java.lang.annotation.*;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/15 11:45
 * @Version:V1.0
 * @Description:MyAnnotation
 *
 */
@Target({ElementType.METHOD,ElementType.TYPE})//约束被注解的类的使用范围
@Inherited//指定被描述的注释可以被描述的类的子类继承，默认使不被子类继承。
@Documented//用于指定javadoc生成API文档时显示该注释
@Retention(RetentionPolicy.RUNTIME)//约束被注解的类的作用范围
/**
 * 1,、RetentionPolicy.SOURCE:作用范围是源码，作用于Java文件中，当执行javac时去除该注解。
 *
 * 2、RetentionPolicy.CLASS：作用范围是二进制码，就是存在于class文件中，当执行Java时去除该注解。
 *
 * 3、RetentionPolicy.RUNTIME：作用范围为运行时，就是我们可以通过动态获取该注释。
 */
public @interface MyAnnotation {
    String name() default "张三";

    String say() default "hello world annotation";

    int age() default 4;

}
