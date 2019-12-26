package com.el.jichu.collection.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author roman.zhang
 * @Date: 2019/9/27 9:45
 * @Version:V1.0
 * @Description:HashMapTest
 */
public class HashMapTest {

    @Test
    public void test1(){
     /*   System.out.println(1 << 30);
        System.out.println(1 << 16);
        System.out.println(0 >>> 16);
        System.out.println(2^16);*/
        HashMap map = new HashMap();
        String key1 = "abc";
        System.out.println((key1.hashCode())^(0 >>> 16));
        map.put(3,30);
        map.put(4,40);
        map.put(1,50);
        map.put(1,10);
        map.put(2,20);


        map.forEach((key,value)->{
            System.out.println(key);
            System.out.println(value);
        });
    }

    @Test
    public void testHashTable(){
        Hashtable hashTable = new Hashtable();
    }

    @Test
    public void testTreeMap(){
        TreeMap treeMap = new TreeMap();
        treeMap.put(4,"qq");
        treeMap.put(5,"qq");
        treeMap.put(6,"qq");
        treeMap.put(7,"qq");
        treeMap.put(1,"qq");
        treeMap.put(2,"qq");
        treeMap.put(3,"qq");


        treeMap.entrySet().stream().forEach((value -> {
            System.out.print(value+",");
        }));
    }


}
