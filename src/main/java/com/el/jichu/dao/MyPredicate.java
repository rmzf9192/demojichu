package com.el.jichu.dao;

@FunctionalInterface
public interface MyPredicate<T> {
    public boolean test(T t);
}
