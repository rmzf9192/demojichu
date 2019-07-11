package com.el.jichu.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Roman.zhang
 * @Date: 2019/7/2 16:42
 * @Version:V1.0
 * @Description:TestList
 */
public class TestList {
    public static void main(String[] args) {
        List<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);
        lists.add(4);

        LinkedList linkedList = new LinkedList();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");
        linkedList.add("F");
        linkedList.add("G");

        linkedList.add(2,"S");



        ArrayList<Object> objects = new ArrayList<>();

        objects.add(3);
        objects.add(5);
        lists.retainAll(objects);

        System.out.println("集合大小");
    }
}
