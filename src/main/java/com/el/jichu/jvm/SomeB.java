package com.el.jichu.jvm;

/**
 * <p>
 * 功能说明
 * </p >
 *
 * @author Roman.Zhang
 * @date 2020/8/20
 */
public class SomeB {
    public SomeB() {
        System.out.println("B construct");
    }

    static { System.out.println("static SomeB"); }
    { System.out.println("B init"); }
}
