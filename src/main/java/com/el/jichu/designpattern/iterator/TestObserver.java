package com.el.jichu.designpattern.iterator;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 15:26
 * @Version:V1.0
 * @Description:TestObserver 此处我们貌似模拟了一个集合类的过程，感觉是不是很爽？其实 JDK 中各个类也都是这些
 * 基本的东西，加一些设计模式，再加一些优化放到一起的，只要我们把这些东西学会了，掌
 * 握好了，我们也可以写出自己的集合类，甚至框架！
 */
public class TestObserver {
    public static void main(String[] args) {
        Collection myCollection = new MyCollection();
        Iterator iterator = myCollection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
