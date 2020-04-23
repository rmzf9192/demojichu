package com.el.jichu.jvm;

import java.util.Random;

/**
 * @author Roman.Zhang
 * @date 2020/4/18
 * @description:
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseG1GC
 */
public class G1Demo {
    public static void main(String[] args) {
        String str = "elitesland";

        while (true){
            str+= str + new Random().nextInt(888888888)+new Random().nextInt(999999999);
            str.intern();
        }
    }
}
