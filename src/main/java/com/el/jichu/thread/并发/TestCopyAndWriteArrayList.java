package com.el.jichu.thread.并发;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/22 16:40
 * @Version:V1.0
 * @Description:TestCopyAndWriteArrayList CopyOnWriteArrayList/CopyOnWriteArraySet:写入并复制
 * 注意：添加操作多时，效率低，因为每次添加时都会复制，开销非常大。
 * 并发迭代多时可以选择
 */
public class TestCopyAndWriteArrayList {
    public static void main(String[] args) {
        CopyAndWriteTest copyAndWriteTest = new CopyAndWriteTest();

        for (int i = 0; i < 10; i++) {
            new Thread(copyAndWriteTest, "AA" + i).start();
        }

    }
}

class CopyAndWriteTest implements Runnable {
    //private static List<String> list=Collections.synchronizedList(new ArrayList<>());
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }

    @Override
    public void run() {

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(Thread.currentThread().getName() + ":" + iterator.next());
            list.add("aa");
        }
    }
}
