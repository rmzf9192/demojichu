package com.el.jichu.io;

import java.io.*;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/7 22:22
 * @Version:V1.0
 * @Description:BufferInputStreamTest
 */
public class BufferInputStreamTest {

    public static void main(String[] args) throws IOException {
        FileInputStream fis=null;
        FileOutputStream fio=null;
        BufferedInputStream bis=null;
        BufferedOutputStream bio=null;

        try{
            fis=new FileInputStream("G:\\个人资料\\1.txt");
            fio=new FileOutputStream("G:\\个人资料\\3.txt");
            bis=new BufferedInputStream(fis);
            bio=new BufferedOutputStream(fio);
            byte[] b=new byte[1024];
            int read=0;
            while((read=bis.read(b))>0){
                bio.write(b,0,read);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bis.close();
            bio.close();
        }
    }
}
