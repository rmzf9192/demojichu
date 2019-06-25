package com.el.jichu.io;

import java.io.File;
import java.io.FilenameFilter;

public class FileLei implements FilenameFilter {
    public static void main(String[] args) {
        new FileLei().f();
    }

    public void f() {
        File f = new File("G:\\study");
        //以字符串的形式，列出当前目录下的所有文件
        String[] list = f.list();
        for (int i = 0; i < list.length; i++) {
            System.out.println("文件名：" + list[i]);
        }
        System.out.println("********************************");

        String[] list1 = f.list(this);

        for (String str : list1) {
            System.out.println("文件名：" + str);
        }
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".txt");
    }
}
