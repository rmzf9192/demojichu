package com.el.jichu.designpattern.uml;

import java.util.Calendar;

/**
 * @author Roman.zhang
 * @Date: 2019/7/8 11:06
 * @Version:V1.0
 * @Description:Person
 */
public class Person {
    private Integer id;
    private String name;

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();

        StringBuilder hello = new StringBuilder("hello");

    }
}
