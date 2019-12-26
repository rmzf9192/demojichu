package com.el.jichu.collection.list;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author roman.zhang
 * @Date: 2019/9/26 14:44
 * @Version:V1.0
 * @Description:TestList
 */
public class TestList1 {

    @Test
    public void testArrayList(){
        ArrayList arrayList = new ArrayList<>();
        arrayList.add("10");

        arrayList.add("11");

//        arrayList.remove(0);
        arrayList.add("11");

        Iterator iterator = arrayList.iterator();

        for (int i = 0; arrayList.iterator().hasNext(); i++) {
            arrayList.remove(i);
            System.out.println(arrayList.get(i));
        }

        while(iterator.hasNext()){
            Object next = iterator.next();
            iterator.remove();
            System.out.println("next:"+next);
        }
        System.out.println("=====");
        for (Object str: arrayList) {
            arrayList.remove(1);
            System.out.println(str);
        }
        Object o = arrayList.get(1);
       /* arrayList.parallelStream().forEach(item->{
            System.out.println(item);
        });

        arrayList.trimToSize();

        arrayList.ensureCapacity(1);

        int[] src = {1,2,3,4,5,6,7,8,9};

        int[] des = new int[5];

        System.arraycopy(src,0,des,0,5);

        Arrays.stream(des).forEach(item -> System.out.println(item));

        System.out.println("+++++++++++++++++++++++++++++");

        Arrays.stream(src).forEach(item -> System.out.println(item));*/

    }


    @Test
    public void testLinkedList(){
        LinkedList linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add("jjj");
        linkedList.addAll(Arrays.asList("aaa"));
        linkedList.add("aaa");

        linkedList.remove("aaa");
        linkedList.get(2);


        ListIterator listIterator = linkedList.listIterator(1);
        System.out.println(listIterator.hasPrevious());
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

        Iterator iterator = linkedList.descendingIterator();

        while(iterator.hasNext()){
            System.out.println(iterator.hasNext());
        }
    }

    @Test
    public void testVector(){
        Vector vector = new Vector();

        CopyOnWriteArrayList syncList = new CopyOnWriteArrayList();

        syncList.add(1);
        syncList.add(2);
        syncList.add(3);

        Iterator iterator = syncList.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
            syncList.add(4);
        }
        Iterator iterator1 = syncList.iterator();

        System.out.println("=====================");

        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }

}
