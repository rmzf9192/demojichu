package com.el.jichu.collection.list;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author Roman.zhang
 * @Date: 2019/7/2 16:42
 * @Version:V1.0
 * @Description:TestList
 */
public class TestList {
    public static void main(String[] args) {
        System.out.println("001".compareTo("001"));
        String time1 = "2019-11-22 13:50:59";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime localDateTime = LocalDateTime.parse(time1, formatter);

        System.out.println(localDateTime.isAfter(LocalDateTime.now()));

        List list = new ArrayList();

        System.out.println("list size "+list.size());
        Map<String,String> strMap = new HashMap<>();

        strMap.put("1","222");
        strMap.put("1","3333");

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
