package com.el.jichu.datastructures.stack;

import java.util.Stack;

/**
 * @author Roman.zhang
 * @Date: 2019/7/10 16:32
 * @Version:V1.0
 * @Description:TestStack
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();

        s.add("a");
        s.add("b");
        s.add("c");
        s.add("a");

        while(s.size()>0){
//            System.out.println(s.pop());
            System.out.println(s.pop());
        }
    }
}
