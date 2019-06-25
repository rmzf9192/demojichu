package com.el.jichu.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/7 22:27
 * @Version:V1.0
 * @Description:InputStreamReaderTest
 */
public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);

        BufferedReader reader= new BufferedReader(streamReader);

        String read=null;

        while((read=reader.readLine())!=null){
            if("exit".equalsIgnoreCase(read)){
                System.exit(1);
            }
            System.out.println("输入内容："+read);
        }
    }
}
