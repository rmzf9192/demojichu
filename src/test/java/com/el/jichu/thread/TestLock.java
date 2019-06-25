package com.el.jichu.thread;

import com.el.jichu.domain.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

    @Test
    public void test1() {
        List<Employee> list = new ArrayList<>();

        System.out.println(list);
    }
}
