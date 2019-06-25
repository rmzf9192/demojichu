package com.el.jichu.io;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/7 22:01
 * @Version:V1.0
 * @Description:FileInputStreamTest
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=null;
        FileReader fir=null;
        try {
            fis=new FileInputStream("G:\\个人资料\\1.txt");
            fir=new FileReader("G:\\个人资料\\1.txt");
            //创建一个字节数组
            byte[] bytes= new byte[1024];
            char[] firReader=new char[1024];
            int readByte=0;
            int readFir=0;
            while((readByte =fis.read(bytes))>0){
                System.out.println(new String(bytes,0,readByte));
            }

            while((readFir=fir.read(firReader))>0){
                System.out.println(new String(firReader,0,readFir));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            fis.close();
            fir.close();
        }

    }
}
