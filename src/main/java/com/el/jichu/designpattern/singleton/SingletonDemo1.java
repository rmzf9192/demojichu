package com.el.jichu.designpattern.singleton;

/**
 * <p>
 *
 * <p>
 *
 * @author Roman.Zhang
 * @date 2021/9/28
 */
public class SingletonDemo1 {

    public static Byte[] by = null;

    static {
        by = new Byte[1024 * 1024 * 10];
    }

    public SingletonDemo1() {
    }

    public static Byte[] getBy(){
        return by;
    }
}
