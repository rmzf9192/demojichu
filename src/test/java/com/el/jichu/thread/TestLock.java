package com.el.jichu.thread;

import com.el.jichu.domain.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    final   String[] str = new String[10];
    @Test
    public void test1() {
        List<Employee> list = new ArrayList<>();

        System.out.println(list);
    }

    @Test
    public void test2(){
        final String[] str = this.str;
        str[0]="1";
        Arrays.asList(str).forEach((s)->{
            System.out.println(s);
        });
    }
}
