package com.el.jichu.jvm;

import java.nio.ByteBuffer;

/**
 * @Auther: roman.zhang
 * @Date: 2019/6/24 16:23
 * @Version:V1.0
 * @Description:DirectBufferMemoryDemo
 */
public class DirectBufferMemoryDemo
{
    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory:"+(sun.misc.VM.maxDirectMemory()/(double)1024/1024)+"MB");
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);

    }
}
