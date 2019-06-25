package com.el.jichu.io;

import java.io.*;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/7 22:31
 * @Version:V1.0
 * @Description:ObjectOutStreamTest
 */
public class ObjectOutStreamTest {
    public static void main(String[] args) {
        OutputStream outputStream=null;
        InputStream inputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        BufferedInputStream bufferedInputStream=null;
        ObjectOutputStream objectOutputStream=null;
        ObjectInputStream objectInputStream=null;

        try{
            outputStream=new FileOutputStream("G:\\个人资料\\1.txt");
            inputStream= new FileInputStream("G:\\个人资料\\1.txt");
            bufferedOutputStream=new BufferedOutputStream(outputStream);
            bufferedInputStream= new BufferedInputStream(inputStream);
            objectOutputStream=new ObjectOutputStream(bufferedOutputStream);

            objectInputStream = new ObjectInputStream(bufferedInputStream);
            Object o = objectInputStream.readObject();
            System.out.println(o);

            objectOutputStream.writeObject(new Object());
            objectOutputStream.close();
            objectInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }
}
