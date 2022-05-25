package com.el.jichu.jvm;

import lombok.val;

import java.util.ArrayList;

public class Dmeo1 {
    public static void main(String[] args) {
        Object o = new Object();
        Dmeo1 dmeo1 = new Dmeo1();
        int s_m_12x22 = 10;

        System.out.println(dmeo1.getClass().getClassLoader().getParent().getParent());
        System.out.println(dmeo1.getClass().getClassLoader().getParent());
        System.out.println(dmeo1.getClass().getClassLoader());


        val list = new ArrayList<String>();
        list.add("jhhh");
        for (val l : list) {
            System.out.println("数组中的元素：" + l);
        }
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "：hello");
            Thread.currentThread().setPriority(2);
        }).start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "：hello");
            Thread.currentThread().setPriority(10);
        }).start();
/*
        String random="www.baidu.com";
        while(true){
            random+=random+new Random().nextInt(999999999)+new Random().nextInt(999999999);
            System.out.println("数据是："+random);
        }*/

        char[] source = "abcdefghijklm".toCharArray();
        int sourceOffset =1;
        int sourceCount = 12;
        char[] target = "efghijk".toCharArray();
        int targetCount = 6;
        val funx = funx(source, sourceOffset, sourceCount, target, targetCount);
        System.out.println(funx);
        System.out.println(f(15,12));
    }

    static int funx(char[] source, int sourceOffset,
             int sourceCount, char[] target, int targetCount
    ) {
        if (targetCount == 0) {
            return 0;
        }
        char first = target[0];
        int max = sourceOffset + (sourceCount - targetCount);
        for (int i = sourceOffset + 0; i <= max; i++) {
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }
            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = 0 + 1; j < end && source[j]== target[k]; j++, k++);
                if (j == end) {
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }

    private static int f(int x,int y)
    {
        if(x<=1)
            return 2 * y;
        if(y<=1)
            return 3*x;
        return f(x-3,y-2);
    }
}
//双亲委派机制+沙箱机制
