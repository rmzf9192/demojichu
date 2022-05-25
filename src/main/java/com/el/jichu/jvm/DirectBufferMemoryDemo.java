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
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);

    }
}
