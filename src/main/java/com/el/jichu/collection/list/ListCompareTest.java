package com.el.jichu.collection.list;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Roman.zhang
 * @Date: 2019/7/3 11:23
 * @Version:V1.0
 * @Description:ListCompareTest
 */
public class ListCompareTest {
    private static final int COUNT = 100000;

    private static LinkedList linkedList = new LinkedList();
    private static ArrayList arrayList = new ArrayList();
    private static Vector vector = new Vector();
    private static Stack stack = new Stack();

    public static void main(String[] args) {

        System.out.println(2 >> 1);
        System.out.println(1 << 30);
        System.out.println(2 << 2);
        System.out.println(3 << 2);
        System.out.println();

        insertByPosition(linkedList);
        insertByPosition(arrayList);
        insertByPosition(vector);
        insertByPosition(stack);

        System.out.println();

        queryList(linkedList);
        queryList(arrayList);
        queryList(vector);
        queryList(stack);

        System.out.println();

        removeByPosition(linkedList);
        removeByPosition(arrayList);
        removeByPosition(vector);
        removeByPosition(stack);


    }

    /**
     * 返回list名称
     * @param list
     * @return
     */
    private static String getListName(List list) {
        if(list instanceof LinkedList) {
            return "LinkedList";
        }else if (list instanceof ArrayList){
            return "ArrayList";

        }else if (list instanceof Stack) {
            return "Stack";
        }else if (list instanceof Vector){
            return "Vector";
        }
        return "List";
    }

    /**
     * 插入元素
     * @param list
     */
    private static void insertByPosition(List list){
        long start = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

        for (int i = 0; i <COUNT ; i++) {
            list.add(i,i+1);
        }
        long end = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

        System.out.println(getListName(list)+":insert "+COUNT+" elements time up "+(end-start));
    }

    /**
     * 获取元素时间
     * @param list
     */
    private static  void queryList(List list){
        long start = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

        for (int i = 0; i <COUNT ; i++) {
            list.get(i);
        }
        long end = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

        System.out.println(getListName(list)+":query "+COUNT+" elements time up "+(end-start));
    }

    private static void removeByPosition(List list){
        long start = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

        for (int i = 0; i <COUNT ; i++) {
            list.remove(0);
        }
        long end = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

        System.out.println(getListName(list)+":remove "+COUNT+" elements time up "+(end-start));
    }
}
