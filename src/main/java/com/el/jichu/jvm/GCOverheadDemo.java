package com.el.jichu.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: roman.zhang
 * @Date: 2019/6/24 16:14
 * @Version:V1.0
 * @Description:GCOverheadDemo
 */
public class GCOverheadDemo {

    public static void main(String[] args) {
        int i = 0;
        List<Object> list = new ArrayList<>();

        try {
            while (true) {
                list.add(String.valueOf(i++).intern());
            }
        } catch (Exception e) {
            System.out.println("*******************i="+i);
            e.printStackTrace();
            throw e;
        }

    }
}
