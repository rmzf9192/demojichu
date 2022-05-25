package com.el.jichu.designpattern.builder;

/**
 * @author roman zhangfei
 * @Date 2019/12/18 13:52
 * @Version V1.0
 */
public class HighHouse extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("高房子地基10m");
    }

    @Override
    public void buildWalls() {
        System.out.println("高房子墙体4m");
    }

    @Override
    public void roofed() {
        System.out.println("高房子屋顶");
    }
}