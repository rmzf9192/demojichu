package com.el.jichu.collection.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

public class TestSet {

    @Test
    public void testHashSet(){
        HashSet  hashSet = new HashSet();

        hashSet.add(null);
        hashSet.add(1);
        hashSet.add(null);
        hashSet.add(2);
        hashSet.add(1);

        Iterator iterator = hashSet.iterator();
    }

}
