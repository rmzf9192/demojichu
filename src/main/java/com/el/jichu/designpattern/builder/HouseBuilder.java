package com.el.jichu.designpattern.builder;

/**
 * @author roman zhangfei
 * @Date 2019/12/18 13:47
 * @Version V1.0
 *  抽象房屋建筑者
 */
public abstract class HouseBuilder {
    protected House house = new House();

    //将建造的流程写好, 抽象的方法
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    //建造房子好， 将产品(房子) 返回
    public House buildHouse() {
        return house;
    }
}