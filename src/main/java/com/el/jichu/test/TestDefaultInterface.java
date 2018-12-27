package com.el.jichu.test;

import com.el.jichu.domain.SubClass;

public class TestDefaultInterface {
    public static void main(String[] args){

        SubClass subClass = new SubClass();

        System.out.println(subClass.getName());

        MyInterface.show();
    }
}
