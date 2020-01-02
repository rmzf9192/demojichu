package com.el.jichu.designpattern.visitor.test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author roman zhangfei
 * @Date 2019/12/18 17:29
 * @Version V1.0
 */
public class ObjectStructure {

    //维护了一个集合
    private List<Person> persons = new LinkedList<>();

    //增加到list
    public void attach(Person p) {
        persons.add(p);
    }
    //移除
    public void detach(Person p) {
        persons.remove(p);
    }

    //显示测评情况
    public void display(Action action) {
        for(Person p: persons) {
            p.accept(action);
        }
    }
}