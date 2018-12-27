package com.el.jichu.io;

import org.omg.SendingContext.RunTime;

import java.io.*;

public class Stream {

    public static void main(String[] args) throws IOException {
          /*  //第一种方式：创建一个输入流读取文件
        InputStream inputStream1 = new FileInputStream("F:\\资料\\Stream.txt");

        //第二种方式：先创建File对象
        File file = new File("F:\\资料\\Stream.txt");
        InputStream inputStream2 = new FileInputStream(file);
*/
       /* //获取jvm参数
        System.out.println("最大内存："+Runtime.getRuntime().maxMemory()/1024/1024);
        System.out.println("总内存："+Runtime.getRuntime().totalMemory()/1024/1024);*/
        //创建文件，并向文件写入指定内容
       /* byte bWrite[] = { 11, 21, 3, 40, 5 };
        OutputStream outputStream = new FileOutputStream("F:\\资料\\test.txt");
        for(int i=0;i<bWrite.length;i++){
            outputStream.write(bWrite[i]);
        }
        outputStream.close();

        //创建输入流，读取文件值
        InputStream inputStream = new FileInputStream("F:\\资料\\test.txt");
        int available = inputStream.available();
        for(int i=0;i<available;i++){
            System.out.println(inputStream.read()+"====");
        }
        inputStream.close();*/

       //如果不存在，则创建文件
        File file = new File("F:\\资料\\test.txt");
        //创建一个输出流对象
        FileOutputStream fos = new FileOutputStream(file);
        //创建一个OutputStreamWriter对象，参数可以指定编码
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");

        //写入缓冲区
        osw.write("中文输入");
        //换行
        osw.write("\r\n");
        osw.write("english");
        //关闭写入流，会将缓冲区写入文件
        osw.close();
        //关闭输出流，释放系统资源
        fos.close();

        //创建FileInputStream 对象
        FileInputStream fis = new FileInputStream(file);
        //创建InputStreamRead对象
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

        StringBuffer stringBuffer = new StringBuffer();

        while(isr.ready()){
            stringBuffer.append((char) isr.read());
        }

        System.out.println(stringBuffer.toString());
        isr.close();

        fis.close();

    }
}
