package com.el.jichu.designpattern.iterator.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 15:38
 * @Version:V1.0
 * @Description:Department
 */
public class Department {
    private String name;
    private String desc;

    public Department(String name, String desc) {
        super();
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
