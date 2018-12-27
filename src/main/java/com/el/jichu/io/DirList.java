package com.el.jichu.io;

import java.io.File;

public class DirList {
    public static void main(String[] args) {
        String dirName="/tmp";
        File file = new File(dirName);

        if(file.isDirectory()){
            String[] list = file.list();
            for(int i=0;i<list.length;i++){
                File file1 = new File(dirName + "/" + list[i]);
                if(file1.isDirectory()){
                    System.out.println(list[i]+":是文件夹");
                }else{
                    System.out.println(list[i]+":是文件");
                }
            }
        }else{
            System.out.println(dirName+":不是文件夹");
        }
    }
}
