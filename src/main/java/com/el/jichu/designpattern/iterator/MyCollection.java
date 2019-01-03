package com.el.jichu.designpattern.iterator;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 15:23
 * @Version:V1.0
 * @Description:MyCollection
 */
public class MyCollection implements Collection {
    public String string[] = {"A","B","C","D","E"};

    @Override
    public Iterator iterator() {
        System.out.println("this:"+this);
        return new MyIterator(this);
    }

    @Override
    public Object get(int i) {
        return string[i];
    }

    @Override
    public int size() {
        return string.length;
    }
}
