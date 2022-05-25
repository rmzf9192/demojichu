package com.el.jichu.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/7 22:17
 * @Version:V1.0
 * @Description:FileOutPutStreamTest
 */
public class FileOutPutStreamTest {

    public static void main(String[] args) throws IOException {
        FileInputStream fis=null;
        FileOutputStream fio=null;

        try{
            fis=new FileInputStream("G:\\个人资料\\1.txt");
            fio=new FileOutputStream("G:\\个人资料\\2.txt");

            byte[] b=new byte[1024];

            int read=0;

            while((read=fis.read(b))>0){
                fio.write(b,0,read);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            fis.close();
            fio.close();
        }
    }
}
