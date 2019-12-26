package com.el.jichu.designpattern.builder;

/**
 * @author roman zhangfei
 * @Date 2019/12/18 13:49
 * @Version V1.0
 */
public class CommonHouse extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("普通房子地基5m");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子砌墙3m");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子屋顶");
    }
}