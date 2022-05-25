package com.el.jichu;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *
 * <p>
 *
 * @author Roman.Zhang
 * @date 2021/10/9
 */
public class MyOutofMemory {

    public static void main(String args[]) {

        List<Demo> mylist = new LinkedList<>();
        while (Boolean.TRUE) {
            mylist.add(new Demo());
        }
    }

}

class Demo {

    public Demo() {
    }
}

