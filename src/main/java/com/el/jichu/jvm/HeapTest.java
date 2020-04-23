package com.el.jichu.jvm;

import java.util.Random;

/**
 * @author Roman.Zhang
 * @date 2020/4/15
 * @description:
 */
public class HeapTest {
    public static void main(String[] args) {
        String str = "elitesland";

        while (true){
            str+= str + new Random().nextInt(888888888)+new Random().nextInt(999999999);
        }
    }
}
