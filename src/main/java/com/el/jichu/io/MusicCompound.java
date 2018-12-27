package com.el.jichu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MusicCompound {
    public static void main(String[] args)  {
        FileOutputStream fileOutputStream=null;
        FileInputStream fileInputStream=null;
        String[] files={"E:\\study\\java-基础阶段\\demomusic-java\\示例歌曲\\星月神话.mp3","E:\\study\\java-基础阶段\\demomusic-java\\示例歌曲\\我只在乎你.mp3"};

        //设置Byte数组，每次读取8k
        byte[] by=new byte[1024*8];
        try {
            //创建合并后的音乐文件
            fileOutputStream= new FileOutputStream("E:\\study\\java-基础阶段\\demomusic-java\\示例歌曲\\合并.mp3");
            int count=0;
            for(int i=0;i<2;i++){
                fileInputStream=new FileInputStream(files[i]);
                //跳过前面3M的音乐内容
                fileInputStream.skip(1024*1024*3);
                //根据是否读取到内容，写入指定合并.mp3中
                while(fileInputStream.read(by)!=-1){
                    fileOutputStream.write(by);
                    count++;
                    System.out.println(count+"：读取的次数");
                    if(count==(1024*2/8)){
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
