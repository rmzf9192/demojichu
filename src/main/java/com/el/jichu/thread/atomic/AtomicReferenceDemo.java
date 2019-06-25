package com.el.jichu.thread.atomic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/14 17:17
 * @Version:V1.0
 * @Description:AtomicReferenceDemo
 */
@Getter
@ToString
@AllArgsConstructor
class User{
    String userName;
    int age;
}
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User z3 = new User("z3", 22);
        User li4 = new User("li4", 23);
        AtomicReference<User> atomicReferenceDemo = new AtomicReference<>();
        atomicReferenceDemo.set(z3);
        System.out.println(atomicReferenceDemo.compareAndSet(z3,li4)+"\t"+atomicReferenceDemo.get().toString());
        System.out.println(atomicReferenceDemo.compareAndSet(z3,li4)+"\t"+atomicReferenceDemo.get().toString());
    }
}
